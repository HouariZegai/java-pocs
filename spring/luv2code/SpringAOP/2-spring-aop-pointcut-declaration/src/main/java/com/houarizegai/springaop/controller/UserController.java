package com.houarizegai.springaop.controller;

import com.houarizegai.springaop.model.User;
import com.houarizegai.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Void> saveUser() {
        User user = new User(1, "Mohamed");
        user.setId(5);
        System.out.println("User name: " + user.getName());
        userService.save(user);
        userService.save();
        userService.greeting("Houari");
        return ResponseEntity.ok().build();
    }

}
