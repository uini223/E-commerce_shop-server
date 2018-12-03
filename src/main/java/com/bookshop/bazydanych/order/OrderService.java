package com.bookshop.bazydanych.order;

import com.bookshop.bazydanych.product.ProductQuantityDTO;
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

	public void addProductToOrder(long orderId, ProductQuantityDTO product) {
		Order order = orderRepository.getOne(orderId);
		order.addProduct(product);
	}
}
