package com.bookshop.bazydanych.basket;

import com.bookshop.bazydanych.basket.productReservation.ProductReservation;
import com.bookshop.bazydanych.basket.productReservation.ProductReservationId;
import com.bookshop.bazydanych.basket.productReservation.ProductReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

	private ProductReservationRepository productReservationRepository;

	public BasketService(ProductReservationRepository productReservationRepository) {
		this.productReservationRepository = productReservationRepository;
	}

	public Basket getBasketForCustomerId(long customerId) {
		return new Basket(productReservationRepository.getByProductReservationId_CustomerId(customerId));
	}

	public void addProductToBasket(long customerId, long productId, long quantity) {
		productReservationRepository.save(new ProductReservation(customerId, productId, quantity));
	}

	public void removeProductFromBasket(long customerId, long productId) {
		productReservationRepository.deleteById(new ProductReservationId(customerId, productId));
	}

	public void updateProductQuantityInBasket(long customerId, long productId, long quantity) {
		ProductReservation productReservation = productReservationRepository
													.getOne(new ProductReservationId(customerId, productId));
		productReservation.updateQuantity(quantity);
		productReservationRepository.save(productReservation);
	}

	public void clearCustomerBasket(long customerId) {
		productReservationRepository.deleteAllByProductReservationId_CustomerId(customerId);
	}
}
