package com.amrfawzi.backendmanagementapp.controllerimpl;
import com.amrfawzi.backendmanagementapp.model.Course;
import com.amrfawzi.backendmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseControllerImpl {

    @Autowired
    private CourseService courseService;

    @GetMapping("/add")
    public String showCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courseAddForm";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses/list";
    }

    @GetMapping("/update/{id}")
    public String showCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "courseUpdateForm";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute Course updatedCourse) {
        Long courseId = updatedCourse.getId();
        courseService.updateCourse(courseId, updatedCourse);
        return "redirect:/courses/list";
    }

    @GetMapping("/list")
    public String showCourseList(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courseList";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }

}