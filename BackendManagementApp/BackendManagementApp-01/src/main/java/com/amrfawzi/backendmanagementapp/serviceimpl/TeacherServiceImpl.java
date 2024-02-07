package com.amrfawzi.backendmanagementapp.serviceimpl;

import com.amrfawzi.backendmanagementapp.model.Teacher;
import com.amrfawzi.backendmanagementapp.repo.TeacherRepository;
import com.amrfawzi.backendmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            // Update existingTeacher properties with those from updatedTeacher
            existingTeacher.setFirstName(updatedTeacher.getFirstName());
            existingTeacher.setLastName(updatedTeacher.getLastName());
            existingTeacher.setSubject(updatedTeacher.getSubject());
            existingTeacher.setExperienceYears(updatedTeacher.getExperienceYears());
            existingTeacher.setEmail(updatedTeacher.getEmail());

            teacherRepository.save(existingTeacher);
        }
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

}
