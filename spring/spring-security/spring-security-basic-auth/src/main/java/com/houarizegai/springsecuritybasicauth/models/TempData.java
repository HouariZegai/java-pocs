package com.houarizegai.springsecuritybasicauth.models;

import java.util.Arrays;
import java.util.List;

public class TempData {
    public static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Houari", 120d),
            new Student(2, "Mohamed", 300d),
            new Student(3, "Fatima", 150d)
    );
}
