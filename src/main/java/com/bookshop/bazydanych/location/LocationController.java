package com.bookshop.bazydanych.location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
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
