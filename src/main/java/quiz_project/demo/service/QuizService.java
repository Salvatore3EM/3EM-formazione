package quiz_project.demo.service;

import quiz_project.demo.model.DTO.Quiz.QuestionDTO;
import quiz_project.demo.model.DTO.Quiz.QuizDTO;
import quiz_project.demo.model.Quiz;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(QuizDTO quizDTO);
    Quiz updateQuestion(Long questionId, QuestionDTO questionDTO);
    void addQuestions(Long quizId, List<QuestionDTO> questionDTOs);
    List<Quiz> getAllQuizzes();
    QuizDTO getQuizById(Long quizId);

}
