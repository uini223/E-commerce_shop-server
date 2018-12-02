package com.bookshop.bazydanych.basket.productReservation;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_reservations")
public class ProductReservation  {

	@EmbeddedId
	private ProductReservationId productReservationId;

	@Column
	private long quantity;

	public ProductReservation() {
	}

	public ProductReservation(long customerId, long productId, long quantity) {
		this.productReservationId = new ProductReservationId(customerId, productId);
		this.quantity = quantity;
	}

	public void updateQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productReservationId.getProductId();
	}

	public long getQuantity() {
		return quantity;
	}

	public ProductReservationId getProductReservationId() {
		return productReservationId;
	}
}
