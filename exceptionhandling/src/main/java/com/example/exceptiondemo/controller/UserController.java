package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.exception.ResourceNotFoundException;
import com.example.exceptiondemo.model.User;
import com.example.exceptiondemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUsers(@PathVariable("id") String id) throws ResourceNotFoundException {
        return userService.getUser(id);
    }
}
