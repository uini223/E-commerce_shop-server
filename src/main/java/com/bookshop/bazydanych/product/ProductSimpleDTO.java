package com.bookshop.bazydanych.product;

import java.io.Serializable;

public class ProductSimpleDTO implements Serializable {

	private static final long serialVersionUID = 4890235417965964472L;

	private long id;
	private String name;
	private String unit;
	private Integer stock;
	private Double price;
	private long quantity;

	public ProductSimpleDTO() {
	}

	public ProductSimpleDTO(long id, String name, String unit, Integer stock, Double price, long quantity) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.stock = stock;
		this.price = price;
		this.quantity = quantity;
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

	public long getId() {
		return id;
	}

	public long getQuantity() {
		return quantity;
	}
}
