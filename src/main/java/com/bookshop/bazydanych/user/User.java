package com.bookshop.bazydanych.user;

import com.bookshop.bazydanych.shared.BaseEntity;
import com.bookshop.bazydanych.user.infrastructure.UserRole;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

	public User(String login, String password) {
		this.login = login;
		this.password = password;
		this.role = UserRole.USER;
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

    public boolean isPasswordCorrect(String password) {
    	return this.password.contentEquals(password);
	}
}
