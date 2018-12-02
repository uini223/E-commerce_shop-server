package com.bookshop.bazydanych.user;

import com.bookshop.bazydanych.customer.Customer;
import com.bookshop.bazydanych.shared.BaseEntity;
import com.bookshop.bazydanych.user.infrastructure.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
    private Customer customer;

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

    public boolean isPasswordCorrect(String password) {
    	return this.password.contentEquals(password);
	}

	public Customer getCustomer() {
		return customer;
	}

	public UserRole getRole() {
		return role;
	}
}
