package com.bookshop.bazydanych.product;

import java.io.Serializable;

public class ProductQuantityDTO implements Serializable {

	private static final long serialVersionUID = -8242777131607987817L;

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
