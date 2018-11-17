package com.bookshop.bazydanych.location;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private Long id;
	private String city;
	private String street;
	private String postCode;
	private String phoneNumber;

	public LocationDTO() {
	}

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
