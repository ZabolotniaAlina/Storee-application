package com.example.storeapp.controller;

import com.example.storeapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(User user) {
        // registration
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String logIn() {
        return "login";
    }
}
