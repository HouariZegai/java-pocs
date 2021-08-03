package com.houarizegai.freemarker.controller;

import com.houarizegai.freemarker.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentList {

    @RequestMapping("/list")
    public String list(Model model) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Tom", 80.5));
        studentList.add(new Student(2, "Jerry", 90.4));
        studentList.add(new Student(3, "Paul", 77.5));
        model.addAttribute("students", studentList);
        return "list";
    }
}
