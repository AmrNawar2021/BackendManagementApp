package com.amrfawzi.backendmanagementapp.controllerimpl;
import com.amrfawzi.backendmanagementapp.model.Quiz;
import com.amrfawzi.backendmanagementapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizControllerImpl {

    @Autowired
    private QuizService quizService;

    @GetMapping("/add")
    public String showQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "quizAddForm";
    }

    @PostMapping("/add")
    public String addQuiz(@ModelAttribute Quiz quiz) {
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.getQuizById(id);
        model.addAttribute("quiz", quiz);
        return "quizUpdateForm";
    }

    @PostMapping("/update")
    public String updateQuiz(@ModelAttribute Quiz updatedQuiz) {
        Long quizId = updatedQuiz.getId();
        quizService.updateQuiz(quizId, updatedQuiz);
        return "redirect:/quizzes/list";
    }




    @GetMapping("/list")
    public String showQuizList(Model model) {
        List<Quiz> quizzes = quizService.getAllQuiz();
        model.addAttribute("quizzes", quizzes);
        return "quizList";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "redirect:/quizzes/list";
    }


}
