package com.houarizegai.springaop.service;

import com.houarizegai.springaop.dao.UserRepository;
import com.houarizegai.springaop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save() {
        userRepository.save();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public String greeting(String name) {
        return "Hello " + name;
    }
}
