package com.cognizant.authorization.model;

public class UserToken {

	private String userid;

	private String authToken;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public UserToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserToken(String userid, String authToken) {
		super();
		this.userid = userid;
		this.authToken = authToken;
	}
	
	
}
