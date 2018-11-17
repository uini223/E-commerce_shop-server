package com.bookshop.bazydanych.customer;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private String firstName;
	private String lastName;
	private long locationId;

	public CustomerDTO() {
	}

	public CustomerDTO(String firstName, String lastName, long locationId) {
		this.firstName = firstName;
		this.lastName = lastName;
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
}
