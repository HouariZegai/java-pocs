package com.houarizegai.springdemo.rest;

import com.houarizegai.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student dara ... only once!
    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();
        students.add(new Student("Houari", "ZEGAI"));
        students.add(new Student("Mohamed", "Omar"));
        students.add(new Student("Fatima", "Zohra"));
    }

    // define endpoint for "/students" - return list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list ..keep it simple for now
        return students.get(studentId);
    }

}
