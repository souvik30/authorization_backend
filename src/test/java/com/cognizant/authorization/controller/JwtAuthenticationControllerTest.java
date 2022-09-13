package com.cognizant.authorization.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorization.AuthorizationServiceApplication;
import com.cognizant.authorization.exception.UserNotFoundException;
import com.cognizant.authorization.model.UserLoginCredential;
import com.cognizant.authorization.model.UserToken;
import com.cognizant.authorization.service.CustomerDetailsService;
import com.cognizant.authorization.service.JwtUtil;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
//@SpringBootTest
public class JwtAuthenticationControllerTest {
	private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceApplication.class);

	@InjectMocks
	private JwtAuthenticationController jwtAuthenticationController;
	
	@Mock
	private UserLoginCredential userLoginCredential;
	
	@Mock
	private UserToken token;
	
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;	
	
	@Mock
	private CustomerDetailsService custdetailservice;
	
	@Mock
	private UserDetails userdetails;
	
	@Mock
	private JwtUtil jwtutil;
	
	@Before
	public void setup() {
		userLoginCredential.setUserid("root");
		userLoginCredential.setPassword("root");
	}
	
	@Test
	public void testLoginPass() throws Exception{
		
		log.info("Start");
		when(custdetailservice.loadUserByUsername("root")).thenReturn(new User("root","root",new ArrayList<>()));
		ResponseEntity<UserToken> responseEntity=jwtAuthenticationController.login(new UserLoginCredential("root","root"));
		log.info("Response Entity {}",responseEntity);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		assertNotNull(responseEntity.getBody());
		assertEquals("root", responseEntity.getBody().getUserid());
		log.info("End");
	}
	
	@Test(expected= UserNotFoundException.class)
	public void testLoginFail() throws Exception{
		log.info("Start");
		when(custdetailservice.loadUserByUsername("abc")).thenThrow(UserNotFoundException.class);
		ResponseEntity<UserToken> responseEntity=jwtAuthenticationController.login(new UserLoginCredential("abc","abc"));
		log.info("Response Entity {}",responseEntity);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertNotNull(statusCode);
		log.info("End");
	}
	
}
