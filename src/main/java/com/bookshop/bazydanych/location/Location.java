package com.bookshop.bazydanych.location;

import com.bookshop.bazydanych.shared.BaseEntity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@Inheritance
@DiscriminatorColumn
public abstract class Location extends BaseEntity {

	@Column
	private String city;

	@Column
	private String street;

	@Column
	private String postCode;

	@Column
	private String phoneNumber;

	public Location() {
	}

	public Location(String city, String street, String postCode, String phoneNumber) {
		this.city = city;
		this.street = street;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
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
