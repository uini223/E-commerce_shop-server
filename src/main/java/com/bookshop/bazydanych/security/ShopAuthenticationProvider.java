package com.bookshop.bazydanych.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ShopAuthenticationProvider implements AuthenticationProvider {

    private SecurityService securityService;

    public ShopAuthenticationProvider(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(securityService.shouldUserBeAuthenticated(name, password)) {
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
            throw new BadCredentialsException("xD");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
