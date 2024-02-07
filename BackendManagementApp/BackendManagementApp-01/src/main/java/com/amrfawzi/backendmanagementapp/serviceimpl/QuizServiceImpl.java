package com.amrfawzi.backendmanagementapp.serviceimpl;

import com.amrfawzi.backendmanagementapp.model.Quiz;
import com.amrfawzi.backendmanagementapp.repo.QuizRepository;
import com.amrfawzi.backendmanagementapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public void updateQuiz(Long id, Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz != null) {
            // Update existingQuiz properties with those from updatedQuiz
            existingQuiz.setTitle(updatedQuiz.getTitle());
            existingQuiz.setTopic(updatedQuiz.getTopic());
            existingQuiz.setNumberOfQuestions(updatedQuiz.getNumberOfQuestions());
            existingQuiz.setDifficultyLevel(updatedQuiz.getDifficultyLevel());

            quizRepository.save(existingQuiz);
        }
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

}
