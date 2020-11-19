package com.houarizegai.springaop.service;

import com.houarizegai.springaop.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save() {
        userRepository.save();
    }
}
