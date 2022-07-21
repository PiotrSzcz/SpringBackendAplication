package com.example.demo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(
                new Student(1,
                        "A",
                        "B",
                        LocalDate.now(),
                        1
                )
        );
    }
}
