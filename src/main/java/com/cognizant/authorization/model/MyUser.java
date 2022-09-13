package com.cognizant.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class MyUser {

	@Id
	@Column(name = "userid", length = 20)
	private String userid;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "username", length = 20)
	private String username;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyUser(String userid, String password, String username) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
	}
	
	

}
