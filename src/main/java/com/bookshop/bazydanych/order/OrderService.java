package com.bookshop.bazydanych.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(long orderId) {
		return orderRepository.getOne(orderId);
	}
}
