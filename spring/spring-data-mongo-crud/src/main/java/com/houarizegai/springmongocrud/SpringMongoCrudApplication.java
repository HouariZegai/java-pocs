package com.houarizegai.springmongocrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongoCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoCrudApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Algeria", "Tiaret", "14000");

            List<String> favouriteSubjects = List.of("Software Engineering", "Java", "Spring framework");
            String email = "engzegai@gmail.com";
            Student student = new Student("Houari", "Zegai", email,
                    Gender.MALE, address, favouriteSubjects, BigDecimal.TEN, LocalDateTime.now());

//            usingMongoQueryAndTemplate(studentRepository, mongoTemplate, email, student);

            studentRepository.findStudentByEmail(email).ifPresentOrElse(std -> {
                System.out.println("Student email already exist!");
            }, () -> {
                studentRepository.insert(student);
            });
        };
    }

    private void usingMongoQueryAndTemplate(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("Found many students with email " + email);
        }

        if (students.isEmpty()) {
            studentRepository.insert(student);
        } else {
            System.out.println("Student already exist!");
        }
    }
}
