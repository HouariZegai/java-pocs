package com.houarizegai.javase.java8;

import java.util.Optional;
import static java.util.Optional.*;

public class OptionalDemo {
    public static void main(String[] args) {
        Employee employee = null;
        printEmployeeName(ofNullable(employee));
        // or
        printEmployeeName(employee);
        printEmployeeName(new Employee());

    }

    public static void printEmployeeName(Optional<Employee> employee) {
//        employee.ifPresent(System.out::println);
        employee.ifPresent(emp -> System.out.println("Employee: " + emp));
    }

    public static void printEmployeeName(Employee employee) {
        ofNullable(employee).ifPresent(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}