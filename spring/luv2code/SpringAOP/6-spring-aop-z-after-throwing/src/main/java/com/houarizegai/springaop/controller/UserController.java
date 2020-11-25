package com.houarizegai.springaop.controller;

import com.houarizegai.springaop.dao.UserRepository;
import com.houarizegai.springaop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> saveUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
