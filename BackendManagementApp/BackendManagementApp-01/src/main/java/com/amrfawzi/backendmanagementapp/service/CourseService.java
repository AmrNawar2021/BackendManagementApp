package com.amrfawzi.backendmanagementapp.service;

import com.amrfawzi.backendmanagementapp.model.Course;

import java.util.List;

public interface CourseService {
    // Create
    Course saveCourse(Course course);

    // Read
    List<Course> getAllCourses();
    Course getCourseById(Long id);

    // Update
    void updateCourse(Long id, Course updatedCourse);

    // Delete
    void deleteCourse(Long id);
}
