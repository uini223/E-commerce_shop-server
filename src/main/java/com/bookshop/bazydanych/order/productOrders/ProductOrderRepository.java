package com.bookshop.bazydanych.order.productOrders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId> {

	List<ProductOrder> getAllByProductOrderId_OrderId(long orderId);
}
