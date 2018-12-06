package com.bookshop.bazydanych.basket;

import com.bookshop.bazydanych.product.ProductSimpleDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {

	private List<ProductSimpleDTO> products;

	public Basket(List<ProductSimpleDTO> products) {
		this.products = new ArrayList<>();
		this.products.addAll(products);
	}

	public List<ProductSimpleDTO> getProducts() {
		return products;
	}
}
