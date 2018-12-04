package com.bookshop.bazydanych.product;

import java.io.Serializable;

public class ProductSimpleDTO implements Serializable {

	private static final long serialVersionUID = 4890235417965964472L;

	private String name;
	private String unit;
	private Integer stock;
	private Double price;

	public ProductSimpleDTO() {
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrice() {
		return price;
	}
}
