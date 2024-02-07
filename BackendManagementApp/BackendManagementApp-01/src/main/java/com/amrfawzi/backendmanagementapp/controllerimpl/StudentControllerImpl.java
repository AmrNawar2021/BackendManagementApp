package com.amrfawzi.backendmanagementapp.controllerimpl;

import com.amrfawzi.backendmanagementapp.model.Student;
import com.amrfawzi.backendmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentControllerImpl {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentAddForm";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentUpdateForm";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student updatedStudent) {
        Long studentId = updatedStudent.getId();
        studentService.updateStudent(studentId, updatedStudent);
        return "redirect:/students/list";
    }


    @GetMapping("/list")
    public String showStudentList(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }


}
