package com.bookshop.bazydanych.shared;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    public BaseNamedEntity() {
    }

    public BaseNamedEntity(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
