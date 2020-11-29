package com.houarizegai.spirngfxcrud.controller;

import com.houarizegai.spirngfxcrud.entities.User;
import com.houarizegai.spirngfxcrud.repository.UserRepository;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @FXML
    public void onAdd() {
        userRepository.save(new User(1, "Houari", 12000d));
        System.out.println("Added to DB");
    }
}
