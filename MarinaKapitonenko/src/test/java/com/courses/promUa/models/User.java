package com.courses.promUa.models;

import org.testng.annotations.Optional;

public class User {
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	private String username, email, password;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
