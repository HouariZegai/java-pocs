package com.houarizegai.springsecuritybasicauth.controller;

import com.houarizegai.springsecuritybasicauth.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Houari", 120d),
            new Student(2, "Mohamed", 300d),
            new Student(3, "Fatima", 150d)
    );

    @GetMapping("{studentId}")
    public Student findStudentById(@PathVariable int studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + "does not exists."));
    }
}
