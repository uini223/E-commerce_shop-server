package com.bookshop.bazydanych.location;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

	private final LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public void createUserLocation(LocationDTO location) {
		Location newLocation = new CustomerLocation(location.getCity(), location.getStreet(), location.getPostCode(),
			location.getPhoneNumber());
		locationRepository.save(newLocation);
	}

	public List<Location> getAll() {
		return locationRepository.findAll();
	}

	public CustomerLocation getUserLocationById(long locationId){
		return locationRepository.getById(locationId);
	}

	public void createPlatformLocation(LocationDTO location) {
		Location newLocation = new PlatformLocation(location.getCity(), location.getStreet(), location.getPostCode(),
			location.getPhoneNumber());
		locationRepository.save(newLocation);
	}
}
