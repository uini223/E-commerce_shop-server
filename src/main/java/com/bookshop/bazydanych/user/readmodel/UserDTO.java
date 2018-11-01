package com.bookshop.bazydanych.user.readmodel;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -1931821111799613841L;

    private long id;
    private String login;
    private String password;

    public UserDTO(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
