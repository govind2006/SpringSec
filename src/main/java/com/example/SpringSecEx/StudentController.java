package com.example.SpringSecEx;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.csrf.CsrfToken;
import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {


    
    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "John Doe", 60),
        new Student(2, "Jane Smith", 75)
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        // Logic to retrieve all students
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        if (csrfToken == null) {
            throw new IllegalStateException("CSRF token not found");
        }
        return csrfToken;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        // Logic to add a new student
        students.add(student);
        return student;
    }
} 

