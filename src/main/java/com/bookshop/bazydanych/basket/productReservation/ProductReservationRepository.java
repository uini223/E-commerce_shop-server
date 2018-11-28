package com.bookshop.bazydanych.basket.productReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReservationRepository extends JpaRepository<ProductReservation, ProductReservationId> {

	List<ProductReservation> getByProductReservationId_CustomerId(long customer_id);

	void deleteAllByProductReservationId_CustomerId(long customerId);
}
