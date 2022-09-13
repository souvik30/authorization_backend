package com.cognizant.authorization.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorization.AuthorizationServiceApplication;
import com.cognizant.authorization.model.MyUser;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDetailsServiceTest {
	private static final Logger log = LoggerFactory.getLogger(AuthorizationServiceApplication.class);
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Mock
	private MyUser myUser;
	
	@Before
	public void setup() {
		myUser.setUserid("root");
		myUser.setPassword("root");
		myUser.setUsername("admin");
	}
	
	@Test
	public void testLoadUserByUsernamePass() throws UsernameNotFoundException{
		log.info("Start");
		UserDetails userDetails=customerDetailsService.loadUserByUsername("root");
		assertNotNull(userDetails);
		assertEquals("root",userDetails.getUsername());
		assertEquals("root",userDetails.getPassword());
		log.info("End");
	}
	
//	@Test(expected=UserNotFoundException.class)
//	public void testLoadUserByUsernameFail() throws UsernameNotFoundException{
//		log.info("Start");
//		UserDetails userDetails=customerDetailsService.loadUserByUsername("user");
//		assertNotNull(userDetails);
//		log.info("End");
//	}
	
}
