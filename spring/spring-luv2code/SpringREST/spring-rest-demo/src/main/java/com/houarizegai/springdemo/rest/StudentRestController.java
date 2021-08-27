package com.houarizegai.springdemo.rest;

import com.houarizegai.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // check the studentid against list size
        if (studentId > students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found - " + studentId);
        }

        return students.get(studentId);
    }

    // for catch an exception this is 2 option:
    // option 1: make this exception handler in this controller class
    // option 2: make global exception handler (ControllerAdvice)
    /*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException se) {
        // create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value());
        error.setMessage(se.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        // create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    */
}
