package com.bookshop.bazydanych.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController  {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@PostMapping("/add")
	public void addNewCustomer(@RequestBody CustomerDTO customerDTO) {
		customerService.addCustomer(customerDTO);
	}

	@GetMapping("/get/user/{id}")
	public Customer getCustomerByUserId(@PathVariable long id) {
		return customerService.getCustomerByUserId(id);
	}

}
