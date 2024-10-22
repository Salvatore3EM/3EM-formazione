package quiz_project.demo.service;

import quiz_project.demo.model.DTO.Score.Result.QuizResultDTO;
import quiz_project.demo.model.DTO.Score.Submit.QuizSubmissionDTO;
import quiz_project.demo.model.DTO.Score.UserResultDTO;
import quiz_project.demo.model.Score;

import java.util.List;

public interface ScoreService {
    Score submitQuiz(QuizSubmissionDTO submissionDTO);
    List<UserResultDTO> getAllUserResults();

    QuizResultDTO getScoreDetailsById(Long scoreId);
}
