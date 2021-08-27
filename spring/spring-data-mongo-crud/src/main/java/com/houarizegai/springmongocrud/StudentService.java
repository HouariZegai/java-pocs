package com.houarizegai.springmongocrud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void deleteStudentById(String idStudent) {
        studentRepository.deleteById(idStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String idStudent) {
        return studentRepository.findStudentById(idStudent)
                .orElseThrow(() -> new RuntimeException(String.format("Student with id %s not found!", idStudent)));
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
