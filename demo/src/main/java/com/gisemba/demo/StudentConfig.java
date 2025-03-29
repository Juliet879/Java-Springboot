package com.gisemba.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student student1 = new Student(
                    "Sansha",
                    "sansha@gmail.com",
                    LocalDate.of(2001, APRIL, 23)
            );
            Student student2 = new Student(
                    "Maddie",
                    "mad@gmail.com",
                    LocalDate.of(1989, APRIL, 23)
            );
            Student student3 = new Student(
                    "Abinas",
                    "abns@gmail.com",
                    LocalDate.of(2003, APRIL, 23)
            );

            repository.saveAll(List.of(student1, student2, student3));
        };
    }
}
