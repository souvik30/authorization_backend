package com.cognizant.authorization.config;

import com.cognizant.authorization.AuthorizationServiceApplication;
import com.cognizant.authorization.service.CustomerDetailsService;
import com.cognizant.authorization.service.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerDetailsService custDetailsService;

	private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceApplication.class);
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("START");
		log.debug("REQUEST {}", request);
		log.debug("RESPONSE {}", response);
		log.debug("FILTER CHAIN {}", filterChain);
		final String authHeader = request.getHeader("Authorization");
		log.debug("AUTH HEADER {}:", authHeader);
		String username = null;
		String jwt = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			log.debug("JWT TOKEN {}:", jwt);
			username = jwtUtil.extractUsername(jwt);
			log.debug("USERNAME {}:", username);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.custDetailsService.loadUserByUsername(username);
			log.debug("USER DETAILS {}:", userDetails);
			if (jwtUtil.validateToken(jwt, userDetails)) {
				log.info("TOKEN IS VALID");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				log.debug("USERNAME PASSWORD AUTHENTICATION TOKEN {}:", usernamePasswordAuthenticationToken);
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
		log.info("END");
	}

}
