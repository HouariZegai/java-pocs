package com.houarizegai.springdemo.rest;

import com.houarizegai.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Houari", "ZEGAI"));
        students.add(new Student("Mohamed", "Omar"));
        students.add(new Student("Fatima", "Zohra"));

        return students;
    }
}
