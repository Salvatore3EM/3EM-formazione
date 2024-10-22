//package quiz_project.demo.service.impl.old;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import quiz_project.demo.model.Question;
//import quiz_project.demo.repository.QuestionsRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//public class QuestionsService {
//
//    @Autowired
//    private QuestionsRepository questionsRepository;
//
//    public List<Question> getAllQuestions() {
//        return questionsRepository.findAll();
//    }
//
//    public Question getQuestionById(Long id) {
//        return questionsRepository.findById(id).orElse(null);
//    }
//
//    public void editQuestionById(Long id, Question NewQuestion) {
//        Question OldQuestion = questionsRepository.findById(id).orElse(null);
//        if (OldQuestion != null) {
//            OldQuestion.setQuestion_text(NewQuestion.getQuestion_text());
//            OldQuestion.setVisibility(NewQuestion.getVisibility());
//            OldQuestion.setCreated_at(LocalDate.now().toString());
//            questionsRepository.save(OldQuestion);
//        }
//    }
//
//    public Question saveQuestion(Question question) {
//        question.setCreated_at(LocalDate.now().toString());
//        return questionsRepository.save(question);
//
//    }
//
//    public List<Question> saveQuestions(List<Question> questionList) {
//        return questionsRepository.saveAll(questionList);
//    }
//
//    public void deleteQuestion(Long id) {
//        questionsRepository.deleteById(id);
//    }
//
//    public void toggleVisibilityQuestionById (Long id) {
//        Question question = questionsRepository.findById(id).orElse(null);
//        if(question.getVisibility()==true) {
//            question.setVisibility(false);
//            questionsRepository.save(question);
//        }
//        else if (question.getVisibility()==false){
//            question.setVisibility(true);
//            questionsRepository.save(question);
//        }
//
//    }
//}
