package com.bookshop.bazydanych.basket;

import com.bookshop.bazydanych.basket.productReservation.ProductReservation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket implements Serializable {

	private List<ProductReservation>  productReservations;

	public Basket(List<ProductReservation> productReservations) {
		this.productReservations = new ArrayList<>();
		Collections.copy(this.productReservations, productReservations);
	}

	public List<ProductReservation> getProductReservations() {
		return productReservations;
	}
}
