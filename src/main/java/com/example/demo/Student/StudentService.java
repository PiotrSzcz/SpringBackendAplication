package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmial = studentRepo.findStudentByEmail(student.getEmail());
        if(studentByEmial.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exist = studentRepo.existsById(studentID);
        if (!exist){
            throw new IllegalStateException("student with id"+studentID+"does not exist");
        }
        studentRepo.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepo.findById(studentID)
                .orElseThrow(() -> new IllegalStateException("student with id"+studentID+"does not exist"));
        if (name != null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }
    }
}
