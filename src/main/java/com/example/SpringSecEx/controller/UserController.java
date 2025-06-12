package com.example.SpringSecEx.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.SpringSecEx.model.Users;
import com.example.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        // This method is not implemented in the original code.
        // You can implement login logic here if needed.
        return userService.verifyUser(user);
    }
        
}