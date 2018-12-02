package com.bookshop.bazydanych.order;

import com.bookshop.bazydanych.shared.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@Column
	@Enumerated(EnumType.STRING)
	private TransportType transportType;

	@Column
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column(insertable = false)
	private Date creationDate;

	@Column
	private Date lastStatusChangeDate;

	@Column
	private long customerId;

	private Order() {
		this.status = OrderStatus.WAITING_FOR_PAYMENT;
		lastStatusChangeDate = new Date();
	}

	public void updateStatus(OrderStatus orderStatus) {
		this.status = orderStatus;
		lastStatusChangeDate = new Date();
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastStatusChangeDate() {
		return lastStatusChangeDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public static class Builder {

		private Order order;

		public Builder() {
			this.order = new Order();
		}

		public Builder withPaymentType(PaymentType paymentType) {
			order.paymentType = paymentType;
			return this;
		}

		public Builder withTransportType(TransportType transportType) {
			order.transportType = transportType;
			return this;
		}

		public Builder withCustomerId(long customerId) {
			order.customerId = customerId;
			return this;
		}

		public Order build() {
			return order;
		}
	}
}
