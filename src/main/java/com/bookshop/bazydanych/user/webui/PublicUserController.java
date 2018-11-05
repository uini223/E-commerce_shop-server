package com.bookshop.bazydanych.user.webui;

import com.bookshop.bazydanych.security.UserAuthenticationService;
import com.bookshop.bazydanych.user.application.UserSecurityService;
import com.bookshop.bazydanych.user.readmodel.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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

//	@PostMapping("/register")
//	public Map register(@RequestBody Map user) {
////		userSecurityService.addNewUser(user.getLogin(), user.getPassword());
//		return login(user);
//	}

	@PostMapping(value = "/login")
    @CrossOrigin(origins = "http://localhost:8081")
	public Map login(@RequestBody final UserDTO login) {
	    System.out.println("user: "+login);
        return Collections.singletonMap("a", "b");
	    //		return Collections.singletonMap("token", authenticationService.login(user.getLogin(), user.getPassword())
//			.orElseThrow(() -> new RuntimeException("invalid login and/or password")));
	}
}
