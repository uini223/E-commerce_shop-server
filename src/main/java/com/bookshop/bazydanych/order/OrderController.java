package com.bookshop.bazydanych.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/all")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/get/{id}")
	public Order getOrderById(@PathVariable long id) {
		return orderService.getOrderById(id);
	}
}
