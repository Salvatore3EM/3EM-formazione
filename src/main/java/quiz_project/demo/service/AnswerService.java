package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Answer;
import quiz_project.demo.repository.AnswersRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswersRepository answersRepository;

    public List<Answer> getAllAnswers() {
        return answersRepository.findAll();
    }

    public Answer getAnswerById(Long id) {
        return answersRepository.findById(id).orElse(null);
    }

    public void editAnswerById(Long id, Answer NewAnswer) {
        Answer OldAnswer = answersRepository.findById(id).orElse(null);
        if (OldAnswer != null) {
            OldAnswer.setAnswer_text(NewAnswer.getAnswer_text());
            OldAnswer.setIs_correct(NewAnswer.getIs_correct());
            OldAnswer.setCreated_at(LocalDate.now().toString());
            answersRepository.save(OldAnswer);

        }
    }

    public Answer saveAnswer(Answer answer) {
        answer.setCreated_at(LocalDate.now().toString());
        return answersRepository.save(answer);
    }

    public List<Answer> saveAnswers(List<Answer> AnswerList) { return answersRepository.saveAll(AnswerList);
    }

    public void deleteAnswer(Long id) {
        answersRepository.deleteById(id);
    }
}

