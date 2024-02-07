package com.amrfawzi.backendmanagementapp.serviceimpl;

import com.amrfawzi.backendmanagementapp.model.Course;
import com.amrfawzi.backendmanagementapp.repo.CourseRepository;
import com.amrfawzi.backendmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            // Update existingCourse properties with those from updatedCourse
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setDepartment(updatedCourse.getDepartment());
            existingCourse.setCreditHours(updatedCourse.getCreditHours());


            courseRepository.save(existingCourse);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

}
