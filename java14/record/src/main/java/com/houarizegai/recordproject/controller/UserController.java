package com.houarizegai.recordproject.controller;

import com.houarizegai.recordproject.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HouariZegai, created on 22/02/2021
 */
@RestController
public class UserController {

    @GetMapping("/")
    public String greetings() {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return List.of(
                new User(1, "houari", "houarizegai14@gmail.com"),
                new User(2, "mohamed", "moh@gmail.com"),
                new User(3, "abdelkader", "kadi@gmail.com")
        );
    }
}
