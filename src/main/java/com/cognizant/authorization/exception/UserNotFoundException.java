package com.cognizant.authorization.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.authorization.AuthorizationServiceApplication;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
	private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceApplication.class);
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		log.info("START");
		log.debug("message{}:", message);
		log.info("END");
	}

}
