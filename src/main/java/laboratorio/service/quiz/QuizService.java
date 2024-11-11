package laboratorio.service.quiz;

import laboratorio.model.quiz.DTO.Quiz.QuestionDTO;
import laboratorio.model.quiz.DTO.Quiz.QuizDTO;
import laboratorio.model.quiz.Quiz;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(QuizDTO quizDTO);
    Quiz updateQuestion(Long questionId, QuestionDTO questionDTO);
    void addQuestions(Long quizId, List<QuestionDTO> questionDTOs);
    List<Quiz> getAllQuizzes();
    QuizDTO getQuizById(Long quizId);

}
