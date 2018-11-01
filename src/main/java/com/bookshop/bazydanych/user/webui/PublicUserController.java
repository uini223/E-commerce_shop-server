package com.bookshop.bazydanych.user.webui;

import com.bookshop.bazydanych.security.UserAuthenticationService;
import com.bookshop.bazydanych.user.application.UserSecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String register(
		@RequestParam("username") final String username,
		@RequestParam("password") final String password) {
		userSecurityService.addNewUser(username, password);
		return login(username, password);
	}

	@PostMapping("/login")
	public String login(
		@RequestParam("username") final String username,
		@RequestParam("password") final String password) {
		return authenticationService.login(username, password)
			.orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	}
}
