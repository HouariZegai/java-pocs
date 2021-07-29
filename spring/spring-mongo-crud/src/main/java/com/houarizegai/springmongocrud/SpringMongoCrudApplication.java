package com.houarizegai.springmongocrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongoCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoCrudApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {
            Address address = new Address("Algeria", "Tiaret", "14000");

            List<String> favouriteSubjects = List.of("Software Engineering", "Java", "Spring framework");
            Student student = new Student("Houari", "Zegai", "houarizegai14@gmail.com",
                    Gender.MALE, address, favouriteSubjects, BigDecimal.TEN, LocalDateTime.now());

            studentRepository.insert(student);
        };
    }
}
