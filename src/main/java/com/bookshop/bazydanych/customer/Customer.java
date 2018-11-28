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

	@Column
	private long userId;

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

	public static class CustomerBuilder {
		private Customer customer;

		public CustomerBuilder() {
			customer = new Customer();
		}

		public CustomerBuilder withFirstName(String firstName) {
			customer.firstName = firstName;
			return this;
		}

		public CustomerBuilder withLastName(String lastName) {
			customer.lastName = lastName;
			return this;
		}

		public CustomerBuilder withUserId(long userId) {
			customer.userId = userId;
			return this;
		}

		public CustomerBuilder withLocation(Location location) {
			customer.location = location;
			return this;
		}

		public Customer build() {
			return customer;
		}
	}
}
