package quiz_project.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Questions;
import quiz_project.demo.repository.QuestionsRepository;

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
            OldQuestion.setCreated_at(NewQuestion.getCreated_at());

        }
    }

    public Questions saveQuestion(Questions question) {
        return questionsRepository.save(question);
    }

    public List<Questions> saveQuestions(List<Questions> questionList) {
        return questionsRepository.saveAll(questionList);
    }

    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }
}
