package com.amrfawzi.backendmanagementapp.service;

import com.amrfawzi.backendmanagementapp.model.Teacher;

import java.util.List;

public interface TeacherService {
    // Create
    Teacher saveTeacher(Teacher teacher);

    // Read
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);

    // Update
    void updateTeacher(Long id, Teacher updatedStudent);

    // Delete
    void deleteTeacher(Long id);
}
