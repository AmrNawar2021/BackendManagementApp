package com.amrfawzi.backendmanagementapp.controller;

import com.amrfawzi.backendmanagementapp.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public interface TeacherController {
    // Create
    @PostMapping
    Teacher saveTeacher(@RequestBody Teacher teacher);

    // Read
    @GetMapping
    List<Teacher> getAllTeachers();

    @GetMapping("/{id}")
    Teacher getTeacherById(@PathVariable Long id);

    // Update
    @PutMapping("/{id}")
    Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher);

    // Delete
    @DeleteMapping("/{id}")
    void deleteTeacher(@PathVariable Long id);
}
