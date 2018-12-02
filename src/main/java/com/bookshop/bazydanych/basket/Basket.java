package com.bookshop.bazydanych.basket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {

	private List<BasketProductDTO> products;

	public Basket(List<BasketProductDTO> products) {
		this.products = new ArrayList<>();
		this.products.addAll(products);
	}

	public List<BasketProductDTO> getProducts() {
		return products;
	}
}
