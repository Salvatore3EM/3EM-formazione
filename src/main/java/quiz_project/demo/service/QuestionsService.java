package quiz_project.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Questions;
import quiz_project.demo.repository.QuestionsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    public Questions getQuestionById(Long id) {
        return questionsRepository.findById(id).orElse(null);
    }

    public void editQuestionById(Long id, Questions NewQuestion) {
        Questions OldQuestion = questionsRepository.findById(id).orElse(null);
        if (OldQuestion != null) {
            OldQuestion.setQuestion_text(NewQuestion.getQuestion_text());
            OldQuestion.setVisibility(NewQuestion.getVisibility());
            OldQuestion.setCreated_at(LocalDate.now().toString());
            questionsRepository.save(OldQuestion);
        }
    }

    public Questions saveQuestion(Questions question) {
        question.setCreated_at(LocalDate.now().toString());
        return questionsRepository.save(question);

    }

    public List<Questions> saveQuestions(List<Questions> questionList) {
        return questionsRepository.saveAll(questionList);
    }

    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }

    public void toggleVisibilityQuestionById (Long id) {
        Questions question = questionsRepository.findById(id).orElse(null);
        if(question.getVisibility()==true) {
            question.setVisibility(false);
            questionsRepository.save(question);
        }
        else if (question.getVisibility()==false){
            question.setVisibility(true);
            questionsRepository.save(question);
        }

    }
}
