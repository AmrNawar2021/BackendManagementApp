package com.amrfawzi.backendmanagementapp.repo;

import com.amrfawzi.backendmanagementapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
