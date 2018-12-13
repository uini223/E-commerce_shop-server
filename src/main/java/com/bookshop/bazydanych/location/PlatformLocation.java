package com.bookshop.bazydanych.location;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(LocationConsts.PLATFORM)
public class PlatformLocation extends Location{

	public PlatformLocation() {
	}

	public PlatformLocation(String city, String street, String postCode, String phoneNumber) {
		super(city, street, postCode, phoneNumber);
	}
}
