package com.bookshop.bazydanych.security;

import com.bookshop.bazydanych.user.readmodel.UserAuthData;
import com.bookshop.bazydanych.user.readmodel.UserDetailsDTO;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     *  Methods logs in with given {@code username} and {@code password}.
     */
    UserAuthData login(String username, String password, Long id);

    /**
     *  Finds user by it's token
     */
    Optional<UserDetailsDTO> findByToken(String token);

    /**
     *  Logs out given {@code user}
     */
    void logout(UserDetailsDTO user);
}
