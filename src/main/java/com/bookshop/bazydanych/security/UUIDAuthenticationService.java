package com.bookshop.bazydanych.security;

import com.bookshop.bazydanych.user.User;
import com.bookshop.bazydanych.user.infrastructure.UserRepository;
import com.bookshop.bazydanych.user.readmodel.UserAuthData;
import com.bookshop.bazydanych.user.readmodel.UserDetailsDTO;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
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
	public UserAuthData login(String username, String password) {
		User user = userRepository.findUserByLogin(username);
		if(user != null && user.isPasswordCorrect((password))) {
			String uuid = UUID.randomUUID().toString();
			UserDetailsDTO userDetails = new UserDetailsDTO(user.getId(), username, password, uuid);

			Optional<UserDetailsDTO> duplicatedUser =
				userTokens.values().stream().filter(userDetails::equals).findAny();

			if(duplicatedUser.isPresent()) {
				return new UserAuthData(duplicatedUser.get().getUUID(), user.getRole());
			} else {
				userTokens.put(uuid, userDetails);
				return new UserAuthData(uuid, user.getRole());
			}

		} else {
			throw new AuthenticationCredentialsNotFoundException("Invalid username or password");
		}
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
