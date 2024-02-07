package com.amrfawzi.backendmanagementapp.repo;

import com.amrfawzi.backendmanagementapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
