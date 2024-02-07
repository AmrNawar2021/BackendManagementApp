package com.amrfawzi.backendmanagementapp.service;

import com.amrfawzi.backendmanagementapp.model.Quiz;

import java.util.List;

public interface QuizService {
    // Create
    Quiz saveQuiz(Quiz quiz);

    // Read
    List<Quiz> getAllQuiz();
    Quiz getQuizById(Long id);

    // Update
    void updateQuiz(Long id, Quiz updatedQuiz);

    // Delete
    void deleteQuiz(Long id);
}
