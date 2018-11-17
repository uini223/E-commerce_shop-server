package com.bookshop.bazydanych.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@PostMapping("/add")
	public void addNewLocation(@RequestBody LocationDTO location) {
		locationService.createLocation(location);
	}

	@GetMapping("/all")
	public List<Location> getAll() {
		return locationService.getAll();
	}
}
