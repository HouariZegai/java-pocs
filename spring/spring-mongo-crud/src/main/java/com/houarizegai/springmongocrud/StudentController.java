package com.houarizegai.springmongocrud;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<Student> getStudentById(@PathVariable String idStudent) {
        return ResponseEntity.ok(studentService.getStudentById(idStudent));
    }

    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String idStudent) {
        studentService.deleteStudentById(idStudent);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
}
