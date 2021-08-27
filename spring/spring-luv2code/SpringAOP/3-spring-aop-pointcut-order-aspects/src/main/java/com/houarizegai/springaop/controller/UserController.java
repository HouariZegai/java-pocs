package com.houarizegai.springaop.controller;

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
        return ResponseEntity.ok().build();
    }

}
