package com.bookshop.bazydanych.shared;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private long id;

    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

}
