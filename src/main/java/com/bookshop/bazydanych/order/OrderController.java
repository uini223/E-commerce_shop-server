package com.bookshop.bazydanych.order;

import com.bookshop.bazydanych.basket.Quantity;
import com.bookshop.bazydanych.product.ProductQuantityDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/add/order/{orderId}/product/{productId}")
	public void addProductToOrder(@PathVariable long orderId, @PathVariable long productId,
								  @RequestBody Quantity quantity) {
		orderService.addProductToOrder(orderId, productId, quantity.getQuantity());
	}

	@GetMapping("/get/{id}/products")
	public List<ProductQuantityDTO> getUserOrderProducts(@PathVariable long id) {
		return orderService.getOrderProducts(id);
	}

	@PostMapping("/add")
	public Order createOrder(@RequestBody OrderDTO orderDTO) {
		return orderService.createOrder(orderDTO.getCustomerId(), orderDTO.getPaymentType(),
			orderDTO.getTransportType());
	}

	@GetMapping("/dictionaries/transport")
	public TransportType[] getTransportTypes() {
		return TransportType.values();
	}

	@GetMapping("/dictionaries/payment")
	public PaymentType[] getPaymentTypes() {
		return PaymentType.values();
	}

	@GetMapping("get/customer/{id}")
	public List<Order> getCustomerOrders(@PathVariable long id) {
		return orderService.getCustomerOrders(id);
	}

}
