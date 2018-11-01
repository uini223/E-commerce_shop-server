package com.bookshop.bazydanych.user.webui;

import com.bookshop.bazydanych.security.UserAuthenticationService;
import com.bookshop.bazydanych.user.User;
import com.bookshop.bazydanych.user.application.UserService;
import com.bookshop.bazydanych.user.readmodel.UserDetailsDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserAuthenticationService authentication;
	private UserService userService;

    public UserController(UserAuthenticationService authentication, UserService userService) {
		this.authentication = authentication;
		this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

	@GetMapping("/current")
	UserDetailsDTO getCurrent(@AuthenticationPrincipal final UserDetailsDTO user) {
		return user;
	}

	@GetMapping("/logout")
	boolean logout(@AuthenticationPrincipal final UserDetailsDTO user) {
		authentication.logout(user);
		return true;
	}

}
