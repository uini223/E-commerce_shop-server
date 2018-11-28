package com.bookshop.bazydanych.basket.productReservation;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductReservationId implements Serializable {

	private long customerId;
	private long productId;

	public ProductReservationId() {
	}

	public ProductReservationId(long customerId, long productId) {
		this.customerId = customerId;
		this.productId = productId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public long getProductId() {
		return productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductReservationId that = (ProductReservationId) o;
		return customerId == that.customerId &&
				   productId == that.productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, productId);
	}
}
