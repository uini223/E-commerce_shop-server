package com.bookshop.bazydanych.product;

public class ProductQuantityDTO {

	private long productId;
	private long quantity;

	public ProductQuantityDTO(long productId, long quantity) {
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
