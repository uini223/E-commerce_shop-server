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

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void editUser(UserDTO newUserData) throws Exception {
//        User user = userRepository.findById(newUserData.getId()).orElseThrow(Exception::new);
//        user.ifPresent(user1 -> {
//            user1.setLogin(newUserData.getLogin());
//            user1.setPassword(newUserData.getPassword());
//        });
//        user.setLogin(newUserData.getLogin());
//        user.setPassword(newUserData.getPassword());

    }


}
