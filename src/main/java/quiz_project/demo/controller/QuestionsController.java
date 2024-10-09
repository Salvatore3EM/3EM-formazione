package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Questions;
import quiz_project.demo.service.QuestionsService;

import java.util.List;

@RestController
@RequestMapping("/api/Questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public List<Questions> getAllQuestions() { return questionsService.getAllQuestions(); }

    @GetMapping("/{id}")
    public Questions getQuestionById(@PathVariable Long id) {
        return questionsService.getQuestionById(id);
    }

    @PutMapping("/{id}")
    public void editQuestionById (@PathVariable Long id, @RequestBody Questions NewQuestion) {
        questionsService.editQuestionById(id,NewQuestion);
    }

    @PostMapping
    public Questions createQuestion(@RequestBody Questions question) {
        return questionsService.saveQuestion(question);
    }

    @PostMapping("/All")
    public List<Questions> createQuestions(@RequestBody List<Questions> questionList) { return questionsService.saveQuestions(questionList); }

    @DeleteMapping("/{id}")
    public void deleteQuestions(@PathVariable Long id) {
        questionsService.deleteQuestion(id);
    }

    @PostMapping("/toggleVisibility/{id}")
    public void toggleVisibilityQuestionById(@PathVariable Long id) { questionsService.toggleVisibilityQuestionById(id);}
}

