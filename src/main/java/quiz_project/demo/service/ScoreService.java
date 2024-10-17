package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Answer;
import quiz_project.demo.model.DTO.AnswerDTO;
import quiz_project.demo.model.DTO.ScoreDTO;
import quiz_project.demo.model.Score;
import quiz_project.demo.repository.AnswersRepository;
import quiz_project.demo.repository.QuizRepository;
import quiz_project.demo.repository.ScoreRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswersRepository answerRepository;

    public List<Score> getAllScore() {
        return scoreRepository.findAll();
    }

    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public void editScoreById(Long id, Score NewScore) {
        Score OldScore = scoreRepository.findById(id).orElse(null);
        if (OldScore != null) {
            OldScore.setName(NewScore.getName());
            OldScore.setLastname(NewScore.getLastname());
            OldScore.setEmail(NewScore.getEmail());
            OldScore.setCreated_at(LocalDate.now().toString());
            scoreRepository.save(OldScore);
        }
    }

    public Score submitScore(ScoreDTO scoreDTO) {
        Score score = new Score();

        score.setQuiz_id(quizRepository.findById(scoreDTO.getQuiz_id()).orElse(null));
        score.setName(scoreDTO.getNome());
        score.setLastname(scoreDTO.getCognome());
        score.setEmail(scoreDTO.getEmail());
        score.setCreated_at(LocalDate.now().toString());
        List<AnswerDTO> answerDTOList;
        List<Long> IDanswers = new ArrayList<>(List.of());
        Long Id;
        AnswerDTO answerDTOID = new AnswerDTO();
        Answer answer = new Answer();
        List<Answer> answerList = new ArrayList<>();
        Answer OldAnswer = new Answer();
        Long Idans = 0L;
        int errore = 0;

        for (int j = 0; j < scoreDTO.getAnswers().size(); j++) {
            answerDTOList = scoreDTO.getAnswers();
            answerDTOID = answerDTOList.get(j);
            Id = answerDTOID.getAnswer_id();
            IDanswers.add(Id);
        }
        Idans = IDanswers.get(0);
        answer = answerRepository.findById(Idans).orElse(null);
        answerList.add(answer);
        OldAnswer = answer;
        for (int i = 1; i < IDanswers.size(); i++) {
            Idans = IDanswers.get(i);
            answer = answerRepository.findById(Idans).orElse(null);
            answerList.add(answer);
            if (OldAnswer.getQuestion_id().equals(answer.getQuestion_id())) {
                errore = errore + 1;
                return null;

            }
            OldAnswer = answer;
        }
        if (errore == 0) {
            score.setAnswers(answerList);
            return scoreRepository.save(score);
        }
        return null;
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

}