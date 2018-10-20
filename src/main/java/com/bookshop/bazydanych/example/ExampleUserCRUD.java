package com.bookshop.bazydanych.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleUserCRUD extends CrudRepository<ExampleUser, Long> {
    ExampleUser getById(long Id);
}
