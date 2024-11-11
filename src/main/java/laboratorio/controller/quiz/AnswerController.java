//package quiz_project.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import quiz_project.demo.model.Answer;
//import quiz_project.demo.service.impl.old.AnswerService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/Answer")
//public class AnswerController {
//
//    @Autowired
//    private AnswerService answerService;
//
//    @GetMapping
//    public List<Answer> getAllAnswers() { return answerService.getAllAnswers(); }
//
//    @GetMapping("/{id}")
//    public Answer getAnswerById(@PathVariable Long id) {
//        return answerService.getAnswerById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void editAnswerById (@PathVariable Long id, @RequestBody Answer NewAnswer) {
//        answerService.editAnswerById(id,NewAnswer);
//    }
//    @PostMapping
//    public Answer createAnswer(@RequestBody Answer answer) {
//        return answerService.saveAnswer(answer);
//    }
//
//    @PostMapping("/All")
//    public List<Answer> createAnswers(@RequestBody List<Answer> AnswerList) { return answerService.saveAnswers(AnswerList); }
//
//    @DeleteMapping("/{id}")
//    public void deleteAnswers(@PathVariable Long id) {
//        answerService.deleteAnswer(id);
//    }
//}
