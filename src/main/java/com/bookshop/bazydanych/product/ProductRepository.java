package com.bookshop.bazydanych.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	Product getById(long id);

	List<Product> getAllByIdIn(Collection<Long> id);
}
