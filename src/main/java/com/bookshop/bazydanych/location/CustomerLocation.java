package com.bookshop.bazydanych.location;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(LocationConsts.CUSTOMER)
public class CustomerLocation extends Location{

	public CustomerLocation() {
	}

	public CustomerLocation(String city, String street, String postCode, String phoneNumber) {
		super(city, street, postCode, phoneNumber);
	}
}
