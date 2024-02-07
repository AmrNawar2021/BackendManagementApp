package com.amrfawzi.backendmanagementapp.controller;

import com.amrfawzi.backendmanagementapp.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public interface StudentController {
    // Create
    @PostMapping
    Student saveStudent(@RequestBody Student student);

    // Read
    @GetMapping
    List<Student> getAllStudents();

    @GetMapping("/{id}")
    Student getStudentById(@PathVariable Long id);

    // Update
    @PutMapping("/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent);

    // Delete
    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id);
}
