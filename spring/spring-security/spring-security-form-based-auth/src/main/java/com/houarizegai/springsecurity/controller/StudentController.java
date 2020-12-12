package com.houarizegai.springsecurity.controller;

import com.houarizegai.springsecurity.models.Student;
import com.houarizegai.springsecurity.models.TempData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @GetMapping("{studentId}")
    public Student findStudentById(@PathVariable int studentId) {
        return TempData.STUDENTS.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + "does not exists."));
    }
}
