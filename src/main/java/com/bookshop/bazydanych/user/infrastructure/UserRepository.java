package com.bookshop.bazydanych.user.infrastructure;

import com.bookshop.bazydanych.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByLogin(String login);

}
