package com.bookshop.bazydanych.user.application;

import com.bookshop.bazydanych.user.User;
import com.bookshop.bazydanych.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserSecurityService {

	private UserRepository userRepository;

	public UserSecurityService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addNewUser(String username, String password) {
		User user = new User(username, password);
		userRepository.save(user);
	}
}
