package com.bookshop.bazydanych.order.productOrders;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_orders")
public class ProductOrder {

	@EmbeddedId
	private ProductOrderId productOrderId;

	@Column
	private long quantity;

	public ProductOrder() {
	}

	public ProductOrder(long orderId, long productId, long quantity) {
		this.productOrderId = new ProductOrderId(orderId, productId);
		this.quantity = quantity;
	}

	public long getProductId() {
		return productOrderId.getProductId();
	}

	public ProductOrderId getProductOrderId() {
		return productOrderId;
	}

	public long getQuantity() {
		return quantity;
	}
}
