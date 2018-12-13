package com.bookshop.bazydanych.order;

import com.bookshop.bazydanych.order.productOrders.ProductOrder;
import com.bookshop.bazydanych.order.productOrders.ProductOrderRepository;
import com.bookshop.bazydanych.product.ProductSimpleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductOrderRepository productOrderRepository;

	public OrderService(OrderRepository orderRepository, ProductOrderRepository productOrderRepository) {
		this.orderRepository = orderRepository;
		this.productOrderRepository = productOrderRepository;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(long orderId) {
		return orderRepository.getById(orderId);
	}

	public List<ProductSimpleDTO> getOrderProducts(long orderId) {
		return productOrderRepository.getAllByProductOrderId_OrderId(orderId).stream()
				   .map(productOrder -> new ProductSimpleDTO(productOrder.getProductId(),
					   productOrder.getProduct().getName(), productOrder.getProduct().getUnit(),
					   productOrder.getProduct().getStock(), productOrder.getProduct().getPrice(),
					   productOrder.getQuantity()))
				   .collect(Collectors.toList());
	}

	public void addProductToOrder(long orderId, long productId, long quantity) {
		productOrderRepository.save(new ProductOrder(orderId, productId, quantity));
	}

	public Order createOrder(long customerId, PaymentType paymentType, TransportType transportType) {
		return orderRepository.save(new Order.Builder()
								 .withCustomerId(customerId)
								 .withPaymentType(paymentType)
								 .withTransportType(transportType)
								 .build());
	}

	public List<Order> getCustomerOrders(long customerId) {
		return orderRepository.getAllByCustomerId(customerId);
	}
}
