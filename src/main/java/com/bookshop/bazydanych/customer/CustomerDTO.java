package com.bookshop.bazydanych.customer;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private String firstName;
	private String lastName;
	private long userId;
	private long locationId;

	public CustomerDTO() {
	}

	public CustomerDTO(String firstName, String lastName, long userId, long locationId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.locationId = locationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getLocationId() {
		return locationId;
	}

	public long getUserId() {
		return userId;
	}
}
