package com.bookshop.bazydanych.customer;

import com.bookshop.bazydanych.location.Location;
import com.bookshop.bazydanych.location.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final LocationService locationService;

	public CustomerService(CustomerRepository customerRepository, LocationService locationService) {
		this.customerRepository = customerRepository;
		this.locationService = locationService;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void addCustomer(CustomerDTO customerDTO) {
		Location location = locationService.getLocationById(customerDTO.getLocationId());
		customerRepository.save(new Customer.CustomerBuilder()
									.withFirstName(customerDTO.getFirstName())
									.withLastName(customerDTO.getLastName())
									.withUserId(customerDTO.getUserId())
									.withLocation(location)
									.build());
	}

	public Customer getCustomerByUserId(long userId) {
		return customerRepository.getByUserId(userId);
	}

}

