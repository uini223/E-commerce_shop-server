package com.bookshop.bazydanych.basket;

public class BasketProductDTO {

	private long productId;
	private long quantity;

	public BasketProductDTO(long productId, long quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public long getQuantity() {
		return quantity;
	}
}
