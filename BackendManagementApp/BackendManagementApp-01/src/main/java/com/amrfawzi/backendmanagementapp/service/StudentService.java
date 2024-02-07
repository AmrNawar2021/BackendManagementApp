package com.amrfawzi.backendmanagementapp.service;

import com.amrfawzi.backendmanagementapp.model.Student;

import java.util.List;

public interface StudentService {
    // Create
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void updateStudent(Long id, Student updatedStudent);
    void deleteStudent(Long id);
}
