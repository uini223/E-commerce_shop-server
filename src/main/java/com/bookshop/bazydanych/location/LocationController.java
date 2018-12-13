package com.bookshop.bazydanych.location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@PostMapping("/user/add")
	public void addNewUserLocation(@RequestBody LocationDTO location) {
		locationService.createUserLocation(location);
	}

	@PostMapping("/platform/add")
	public void addNewPlatformLocation(@RequestBody LocationDTO location) {
		locationService.createPlatformLocation(location);
	}

	@GetMapping("/all")
	public List<Location> getAll() {
		return locationService.getAll();
	}
}
