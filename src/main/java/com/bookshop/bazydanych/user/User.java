package com.bookshop.bazydanych.user;

import com.bookshop.bazydanych.shared.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String password;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
