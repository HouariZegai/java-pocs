package com.houarizegai.springwebsecurity.services;

import com.houarizegai.springwebsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    void save(User user);

    void deleteById(int id);
}
