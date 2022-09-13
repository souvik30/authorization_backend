package com.cognizant.authorization.model;

public class UserLoginCredential {

	private String userid;

	private String password;

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

	public UserLoginCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginCredential(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	
	
}
