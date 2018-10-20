package com.bookshop.bazydanych.example;


import com.bookshop.bazydanych.shared.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "example_users")
public class ExampleUser extends BaseNamedEntity {

    public ExampleUser() {
    }

    public ExampleUser(long id, String name) {
        super(id, name);
    }
}
