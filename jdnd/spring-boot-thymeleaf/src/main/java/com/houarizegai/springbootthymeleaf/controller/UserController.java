package com.houarizegai.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/demo")
    public String demo(Model model) {
        model.addAttribute("msg", "Hello Thymeleaf!");

        return "demo";
    }
}
