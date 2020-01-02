package com.houarizegai.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/demo")
    public String demo(Model model) {
        model.addAttribute("msg", "Hello Thymeleaf!");
        double grade = 90.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));

        return "demo";
    }

    private String convertGPA(double grade) {
        if(grade > 90)
            return "A";
        else if (grade < 90 && grade >= 80)
            return "B";
        else if (grade < 80 && grade >= 70)
            return "C";
        else if (grade < 70 && grade >= 60)
            return "D";
        else
            return "F";
    }
}
