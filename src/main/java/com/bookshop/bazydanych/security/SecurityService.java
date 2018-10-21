package com.bookshop.bazydanych.security;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean shouldUserBeAuthenticated(String login, String password) {
        return true;
    }
}
