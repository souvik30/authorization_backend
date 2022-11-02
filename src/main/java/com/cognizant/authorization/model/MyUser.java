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

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "user_type", length = 20)
	private String user_type;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

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

	public MyUser(String userid, String password, String username, String name, String user_type) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.name = name;
		this.user_type = user_type;
	}
}
