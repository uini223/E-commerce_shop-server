package com.bookshop.bazydanych.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exampleUser")
public class ExampleUserController {

    private ExampleUserCRUD exampleUserCRUD;

    public ExampleUserController(ExampleUserCRUD exampleUserCRUD) {
        this.exampleUserCRUD = exampleUserCRUD;
    }

    @GetMapping("/{id}")
    public ExampleUser getUserById(@PathVariable("id") long id) {
        return exampleUserCRUD.getById(id);
    }
}
