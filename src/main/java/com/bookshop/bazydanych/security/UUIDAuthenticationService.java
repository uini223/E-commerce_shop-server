package com.bookshop.bazydanych.security;

import com.bookshop.bazydanych.user.User;
import com.bookshop.bazydanych.user.infrastructure.UserRepository;
import com.bookshop.bazydanych.user.readmodel.UserDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDAuthenticationService implements UserAuthenticationService {

	private UserRepository userRepository;
	private static HashMap<String, UserDetailsDTO> userTokens = new HashMap<>();

	public UUIDAuthenticationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<String> login(String username, String password) {
		User user = userRepository.findUserByLogin(username);
		if(user.isPasswordCorrect((password))) {
			String uuid = UUID.randomUUID().toString();
			UserDetailsDTO userDetails = new UserDetailsDTO(user.getId(), username, password, uuid);
			if(userTokens.values().contains(userDetails)) {
				return Optional.empty();
			}
			userTokens.put(uuid, userDetails);
			return Optional.of(uuid);
		}
		return Optional.empty();
	}

	@Override
	public Optional<UserDetailsDTO> findByToken(String token) {
		return Optional.ofNullable(userTokens.get(token));
	}

	@Override
	public void logout(UserDetailsDTO user) {
		userTokens.remove(user.getUUID());
	}
}
