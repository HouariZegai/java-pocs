package com.houarizegai.springbootvalidation.controller;

import com.houarizegai.springbootvalidation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping("add")
    public String toAdd(User user) {
        return "add";
    }

    @RequestMapping(value = "addUser")
    public String add(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "add";
        }
        System.out.println("Save user =" + user);

        return "success";
    }
}
