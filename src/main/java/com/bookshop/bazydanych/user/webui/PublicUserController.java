package com.bookshop.bazydanych.user.webui;

import com.bookshop.bazydanych.security.UserAuthenticationService;
import com.bookshop.bazydanych.user.application.UserSecurityService;
import com.bookshop.bazydanych.user.readmodel.UserAuthData;
import com.bookshop.bazydanych.user.readmodel.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/users")
public class PublicUserController {

	private UserAuthenticationService authenticationService;
	private UserSecurityService userSecurityService;

	public PublicUserController(UserAuthenticationService authenticationService,
								UserSecurityService userSecurityService) {
		this.authenticationService = authenticationService;
		this.userSecurityService = userSecurityService;
	}

	@PostMapping("/register")
	public void register(@RequestBody UserDTO user) {
		userSecurityService.addNewUser(user.getLogin(), user.getPassword());
	}

	@PostMapping(value = "/login")
	public UserAuthData login(@RequestBody final UserDTO user) {
		return authenticationService.login(user.getLogin(), user.getPassword());
	}
}
