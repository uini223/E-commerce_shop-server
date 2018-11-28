package com.bookshop.bazydanych.user.readmodel;

import com.bookshop.bazydanych.user.infrastructure.UserRole;

import java.io.Serializable;

public class UserAuthData implements Serializable {

	private static final long serialVersionUID = 1586413543635043416L;

	private String token;
	private UserRole userRole;

	public UserAuthData(String token, UserRole userRole) {
		this.token = token;
		this.userRole = userRole;
	}

	public String getToken() {
		return token;
	}

	public UserRole getUserRole() {
		return userRole;
	}
}
