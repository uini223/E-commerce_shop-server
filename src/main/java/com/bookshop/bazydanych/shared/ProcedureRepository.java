package com.bookshop.bazydanych.shared;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Repository
public class ProcedureRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void moveProductsFromBasketToOrder(Long customerId, Long orderId) {
		String queryString = "SELECT \"create_order\"(%d, %d)";
		queryString = String.format(queryString, customerId, orderId);
		Query query = entityManager.createNativeQuery(queryString);
		query.getSingleResult();
	}

	@Transactional
	public BigDecimal getTotalPrice(long customerId) {
		String queryString = "SELECT \"tax\"(%d, %f)";
		queryString = String.format(queryString, customerId, 0.23);
		Query query = entityManager.createNativeQuery(queryString);
		return (BigDecimal) query.getSingleResult();
	}
}
