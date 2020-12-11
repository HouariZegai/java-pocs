package com.houarizegai.springsecuritybasicauth.controller;

import com.houarizegai.springsecuritybasicauth.models.Student;
import com.houarizegai.springsecuritybasicauth.models.TempData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    @GetMapping
    public List<Student> getAllStudents() {
        return TempData.STUDENTS;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        System.out.println("Added: " + student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Integer id) {
        System.out.println("Delete student id: " + id);
    }

    @PutMapping("{id}")
    public void deleteStudent(@PathVariable Integer id, @RequestBody Student student) {
        System.out.println("Update student id: " + id);
        System.out.println(student);
    }

}
