package com.amrfawzi.backendmanagementapp.controller;

import com.amrfawzi.backendmanagementapp.model.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public interface CourseController {
    // Create
    @PostMapping
    Course saveCourse(@RequestBody Course course);

    // Read
    @GetMapping
    List<Course> getAllCourses();

    @GetMapping("/{id}")
    Course getCourseById(@PathVariable Long id);

    // Update
    @PutMapping("/{id}")
    Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse);

    // Delete
    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id);
}
