package com.bookshop.bazydanych.user.infrastructure;

public enum UserRole {
	USER("USER"),
	ADMIN("ADMIN"),
	SUPER_USER("SUPER_USER");

	private String value;

	UserRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
