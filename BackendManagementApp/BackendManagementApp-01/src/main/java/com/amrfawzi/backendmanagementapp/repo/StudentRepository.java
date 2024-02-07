package com.amrfawzi.backendmanagementapp.repo;

import com.amrfawzi.backendmanagementapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
