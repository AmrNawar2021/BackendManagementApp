package com.amrfawzi.backendmanagementapp.controller;

import com.amrfawzi.backendmanagementapp.model.Quiz;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public interface QuizController {
    // Create
    @PostMapping
    Quiz saveQuiz(@RequestBody Quiz quiz);

    // Read
    @GetMapping
    List<Quiz> getAllQuiz();

    @GetMapping("/{id}")
    Quiz getQuizById(@PathVariable Long id);

    // Update
    @PutMapping("/{id}")
    Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz);

    // Delete
    @DeleteMapping("/{id}")
    void deleteQuiz(@PathVariable Long id);
}

