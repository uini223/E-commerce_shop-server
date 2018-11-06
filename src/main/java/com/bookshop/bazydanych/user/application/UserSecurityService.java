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
		User user = userRepository.findUserByLogin(username);
		if(user == null) {
			User newUser = new User(username, password);
			userRepository.save(newUser);
		} else {
			throw new RuntimeException("User already exists !");
		}

	}
}
