package com.example.SpringSecEx.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.csrf.CsrfToken;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import com.example.SpringSecEx.model.Student;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of(
        new Student(1, "John Doe", 60),
        new Student(2, "Jane Smith", 75)
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
