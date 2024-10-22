package quiz_project.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.*;
import quiz_project.demo.model.DTO.Score.Result.AnswerResultDTO;
import quiz_project.demo.model.DTO.Score.Result.QuestionResultDTO;
import quiz_project.demo.model.DTO.Score.Result.QuizResultDTO;
import quiz_project.demo.model.DTO.Score.Submit.QuizSubmissionDTO;
import quiz_project.demo.model.DTO.Score.UserResultDTO;
import quiz_project.demo.repository.AnswerRepository;
import quiz_project.demo.repository.QuizRepository;
import quiz_project.demo.repository.ScoreRepository;
import quiz_project.demo.service.ScoreService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score submitQuiz(QuizSubmissionDTO submissionDTO) {
        // Trova il quiz per l'ID
        Quiz quiz = quizRepository.findById(submissionDTO.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Crea l'oggetto Score
        Score score = new Score();
        score.setName(submissionDTO.getName());
        score.setLastname(submissionDTO.getLastname());
        score.setEmail(submissionDTO.getEmail());
        score.setCreated_at(LocalDateTime.now().toString());
        score.setQuiz_id(quiz);

        // Recupera le risposte inviate dall'utente
        List<Answer> submittedAnswers = submissionDTO.getAnswers().stream()
                .map(answerDTO -> answerRepository.findById(answerDTO.getAnswerId())
                        .orElseThrow(() -> new RuntimeException("Answer not found")))
                .collect(Collectors.toList());

        score.setAnswers(submittedAnswers);

        // Salva il punteggio
        return scoreRepository.save(score);
    }

    @Override
    public List<UserResultDTO> getAllUserResults() {
        return scoreRepository.findAll().stream().map(score -> {
            // Conta le risposte corrette
            long correctAnswers = score.getAnswers().stream()
                    .filter(Answer::getIs_correct).count();
            long totalAnswers = score.getAnswers().size();
            long incorrectAnswers = totalAnswers - correctAnswers;

            return new UserResultDTO(
                    score.getName(),
                    score.getLastname(),
                    score.getEmail(),
                    score.getCreated_at(),
                    score.getQuiz_id().getTitle(),
                    correctAnswers,
                    incorrectAnswers
            );
        }).collect(Collectors.toList());
    }

    @Override
    public QuizResultDTO getScoreDetailsById(Long scoreId) {
        Score score = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new RuntimeException("Score not found"));

        // Otteniamo le risposte dell'utente
        List<Long> userAnswerIds = score.getAnswers().stream()
                .map(Answer::getId)
                .collect(Collectors.toList());

        // Costruiamo la lista delle domande con le risposte e il flag `isUserChoice`
        List<QuestionResultDTO> questionResults = score.getQuiz_id().getQuestions().stream().map(question -> {
            List<AnswerResultDTO> answerResults = question.getAnswers().stream().map(answer -> {
                return new AnswerResultDTO(
                        answer.getId(),
                        answer.getAnswer_text(),
                        answer.getIs_correct(),
                        userAnswerIds.contains(answer.getId())  // Flag per `isUserChoice`
                );
            }).collect(Collectors.toList());

            return new QuestionResultDTO(
                    question.getQuestion_text(),
                    question.getId(),
                    answerResults
            );
        }).collect(Collectors.toList());

        // Creiamo l'oggetto QuizResultDTO
        return new QuizResultDTO(
                score.getQuiz_id().getTitle(),
                score.getName(),
                score.getLastname(),
                score.getEmail(),
                score.getCreated_at(),
                questionResults
        );
    }

}
