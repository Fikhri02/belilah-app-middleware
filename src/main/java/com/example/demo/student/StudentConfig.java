package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration //contains one or more @Bean
public class StudentConfig {

    @Bean//tells Spring that the method returns a Spring Bean, which will be managed by the Spring container.
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) { //CommandLineRunner is a functional interface provided by Spring Boot. It has a run method that is executed when the application starts.
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(1970, Month.APRIL,23)
            );

            Student ahmad = new Student(
                "Ahmad",
                "ahmad@gmail.com",
                LocalDate.of(1987, Month.AUGUST,21)
            );

            studentRepository.saveAll(List.of(ahmad, mariam));
        };
    }
}
