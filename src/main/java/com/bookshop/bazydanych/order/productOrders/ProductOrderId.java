package com.bookshop.bazydanych.order.productOrders;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductOrderId implements Serializable {

	private long orderId;
	private long productId;

	public ProductOrderId() {
	}

	public ProductOrderId(long orderId, long productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getProductId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductOrderId that = (ProductOrderId) o;
		return orderId == that.orderId &&
				   productId == that.productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
}
