package com.amrfawzi.backendmanagementapp.controllerimpl;

import com.amrfawzi.backendmanagementapp.model.Student;
import com.amrfawzi.backendmanagementapp.model.Teacher;
import com.amrfawzi.backendmanagementapp.service.StudentService;
import com.amrfawzi.backendmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherControllerImpl {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/add")
    public String showTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacherAddForm";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teacherUpdateForm";
    }

    @PostMapping("/update")
    public String updateTeacher(@ModelAttribute Teacher updatedTeacher) {
        Long teacherId = updatedTeacher.getId();
        teacherService.updateTeacher(teacherId, updatedTeacher);
        return "redirect:/teachers/list";
    }

    @GetMapping("/list")
    public String showTeacherList(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacherList";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers/list";
    }


}
