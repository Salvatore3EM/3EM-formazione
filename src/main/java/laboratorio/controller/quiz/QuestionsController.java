//package quiz_project.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import quiz_project.demo.model.Question;
//import quiz_project.demo.service.impl.old.QuestionsService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/Questions")
//public class QuestionsController {
//
//    @Autowired
//    private QuestionsService questionsService;
//
//    @GetMapping
//    public List<Question> getAllQuestions() { return questionsService.getAllQuestions(); }
//
//    @GetMapping("/{id}")
//    public Question getQuestionById(@PathVariable Long id) {
//        return questionsService.getQuestionById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void editQuestionById (@PathVariable Long id, @RequestBody Question NewQuestion) {
//        questionsService.editQuestionById(id,NewQuestion);
//    }
//
//    @PostMapping
//    public Question createQuestion(@RequestBody Question question) {
//        return questionsService.saveQuestion(question);
//    }
//
//    @PostMapping("/All")
//    public List<Question> createQuestions(@RequestBody List<Question> questionList) { return questionsService.saveQuestions(questionList); }
//
//    @DeleteMapping("/{id}")
//    public void deleteQuestions(@PathVariable Long id) {
//        questionsService.deleteQuestion(id);
//    }
//
//    @PostMapping("/toggleVisibility/{id}")
//    public void toggleVisibilityQuestionById(@PathVariable Long id) { questionsService.toggleVisibilityQuestionById(id);}
//}
//
