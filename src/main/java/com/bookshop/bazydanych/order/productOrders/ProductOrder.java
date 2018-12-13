package com.bookshop.bazydanych.order.productOrders;

import com.bookshop.bazydanych.product.Product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_orders")
public class ProductOrder {

	@EmbeddedId
	private ProductOrderId productOrderId;

	@Column
	private long quantity;

	@ManyToOne
	@JoinColumn(name="productId", insertable = false, updatable = false)
	private Product product;

	public ProductOrder() {
	}

	public ProductOrder(long orderId, long productId, long quantity) {
		this.productOrderId = new ProductOrderId(orderId, productId);
		this.quantity = quantity;
	}

	public long getProductId() {
		return productOrderId.getProductId();
	}

	public ProductOrderId getProductOrderId() {
		return productOrderId;
	}

	public long getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
}
