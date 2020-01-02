package com.houarizegai.springbootvalidation.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "username cannot be empty")
    private String name;
    @NotEmpty(message = "password cannot be empty")
    @Length(min = 6, max = 10)
    private String password;
    @Email
    private String email;
    @Min(value = 0, message = "grade must be greater or equal to 0")
    @Max(value = 20, message = "grade must be less or equal to 20")
    private Double grade;

    public User(String name, String password, String email, Double grade) {
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                '}';
    }
}
