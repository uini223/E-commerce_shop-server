package com.bookshop.bazydanych.user;

import com.bookshop.bazydanych.shared.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "customer_id")
    private Long customer_id;

    public User(long id, String login, String password, Long customer_id) {
        super(id);
        this.login = login;
        this.password = password;
        this.customer_id = customer_id;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getCustomer_id() {
        return customer_id;
    }
}
