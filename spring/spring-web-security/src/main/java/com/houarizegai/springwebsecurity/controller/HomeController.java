package com.houarizegai.springwebsecurity.controller;

import com.houarizegai.springwebsecurity.model.User;
import com.houarizegai.springwebsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public void HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/sign-in")
    public String signIn(User user) {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUp(User user) {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpForm(User user) {
        userService.save(user);
        return "sign-up";
    }


}
