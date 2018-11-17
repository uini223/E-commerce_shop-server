package com.bookshop.bazydanych.location;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	private final LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public void createLocation(LocationDTO location) {
		Location newLocation = new Location(location.getCity(), location.getStreet(), location.getPostCode(),
			location.getPhoneNumber());
		locationRepository.save(newLocation);
	}
}
