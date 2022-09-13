package com.cognizant.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AuthorizationServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceApplication.class);
	public static void main(String[] args) {
		log.debug("START");
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		log.debug("END");
	}

}
