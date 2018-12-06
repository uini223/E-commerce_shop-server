package com.bookshop.bazydanych.user.readmodel;

import com.bookshop.bazydanych.user.infrastructure.UserRole;

import java.io.Serializable;

public class UserAuthData implements Serializable {

	private static final long serialVersionUID = 1586413543635043416L;

	private String token;
	private UserRole userRole;
	private Long userid;

	public UserAuthData(String token, UserRole userRole, Long userid) {
		this.token = token;
		this.userRole = userRole;
		this.userid = userid;
	}

	public String getToken() {
		return token;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public Long getUserid() {
		return userid;
	}
}
