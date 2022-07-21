package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandRunner(StudentRepo repo){
        return args -> {
            Student A = new Student(
                    "A",
                    "B",
                    LocalDate.now()
            );
            Student AA = new Student(
                    "AA",
                    "BB",
                    LocalDate.now()
            );
            repo.saveAll(
                    List.of(A, AA)
            );
        };
    }
}
