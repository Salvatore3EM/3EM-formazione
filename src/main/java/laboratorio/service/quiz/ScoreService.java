package laboratorio.service.quiz;

import laboratorio.model.quiz.DTO.Score.Result.QuizResultDTO;
import laboratorio.model.quiz.DTO.Score.Submit.QuizSubmissionDTO;
import laboratorio.model.quiz.DTO.Score.UserResultDTO;
import laboratorio.model.quiz.Score;

import java.util.List;

public interface ScoreService {
    Score submitQuiz(QuizSubmissionDTO submissionDTO);
    List<UserResultDTO> getAllUserResults();

    QuizResultDTO getScoreDetailsById(Long scoreId);
}
