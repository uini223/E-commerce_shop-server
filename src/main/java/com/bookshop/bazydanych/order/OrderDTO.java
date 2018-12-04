package com.bookshop.bazydanych.order;

import java.io.Serializable;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = -9107815671803117364L;

	private long customerId;
	private PaymentType paymentType;
	private TransportType transportType;

	public OrderDTO() {
	}

	public long getCustomerId() {
		return customerId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public TransportType getTransportType() {
		return transportType;
	}
}
