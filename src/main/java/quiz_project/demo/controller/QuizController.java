package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.DTO.Quiz.QuestionDTO;
import quiz_project.demo.model.DTO.Quiz.QuizDTO;
import quiz_project.demo.model.Quiz;
import quiz_project.demo.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz quiz = quizService.createQuiz(quizDTO);
        return ResponseEntity.ok(quiz);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<Quiz> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) {
        Quiz quiz = quizService.updateQuestion(id, questionDTO);
        return ResponseEntity.ok(quiz);
    }

    @PostMapping("/{quizId}/questions")
    public ResponseEntity<Void> addQuestions(@PathVariable Long quizId, @RequestBody List<QuestionDTO> questionDTOs) {
        quizService.addQuestions(quizId, questionDTOs);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long quizId) {
        QuizDTO quizDTO = quizService.getQuizById(quizId);
        return ResponseEntity.ok(quizDTO);
    }
}
