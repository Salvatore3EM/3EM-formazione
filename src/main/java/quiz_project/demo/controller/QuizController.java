package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Quiz;
import quiz_project.demo.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/Quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAllQuizzes() { return quizService.getAllQuizzes(); }

    @GetMapping("/{id}")
    public Quiz getQuizById (@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PutMapping("/{id}")
    public void editQuizById (@PathVariable Long Id, @RequestBody Quiz NewQuiz) {
        quizService.editQuizById(Id,NewQuiz);
    }
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz (@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
