package com.bookshop.bazydanych.basket;

import com.bookshop.bazydanych.product.ProductQuantityDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {

	private List<ProductQuantityDTO> products;

	public Basket(List<ProductQuantityDTO> products) {
		this.products = new ArrayList<>();
		this.products.addAll(products);
	}

	public List<ProductQuantityDTO> getProducts() {
		return products;
	}
}
