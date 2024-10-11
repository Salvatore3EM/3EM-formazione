package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Answer;
import quiz_project.demo.model.DTO.QuestionsDTO;
import quiz_project.demo.model.Questions;
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
    public void editQuizById (@PathVariable Long id, @RequestBody Quiz NewQuiz) {
        quizService.editQuizById(id,NewQuiz);
    }
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @PostMapping("/All")
    public List<Quiz> createQuizzes(@RequestBody List<Quiz> quizList) { return quizService.saveQuizzes(quizList); }

    @PostMapping("/add/{id}")
    public Object addQuiz(@PathVariable Long id, @RequestBody List<QuestionsDTO> questions) {
        return quizService.addQuiz(id,questions); }

    @DeleteMapping("/{id}")
    public void deleteQuiz (@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    @PostMapping("/toggleVisibility/{id}")
    public void toggleVisibilityQuizById(@PathVariable Long id) { quizService.toggleVisibilityQuizById(id);}

    @GetMapping("/AllVisible")
    public List<Quiz> AllQuizVisible() { return quizService.AllQuizVisible(); }
}
