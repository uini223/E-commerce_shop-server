package com.bookshop.bazydanych.customer;

import com.bookshop.bazydanych.location.Location;
import com.bookshop.bazydanych.shared.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

	@Column
	private String firstName;

	@Column
	private String lastName;

	@OneToOne
	private Location location;

	public Customer() {
	}

	public Customer(String firstName, String lastName, Location location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCustomerFullName() {
		return firstName + " " + lastName;
	}

	public Location getLocation() {
		return location;
	}
}
