package com.bookshop.bazydanych.basket.productReservation;

import com.bookshop.bazydanych.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "product_reservations")
public class ProductReservation  {

	@EmbeddedId
	private ProductReservationId productReservationId;

	@Column
	private long quantity;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product product;

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

	public Product getProduct() {
		return product;
	}

    public void setProductId(Long id){
	    this.productReservationId.setProductId(id);
    }
}
