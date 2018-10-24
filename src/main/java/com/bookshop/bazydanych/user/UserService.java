package com.bookshop.bazydanych.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        return userRepository.findAll();

    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }


}
