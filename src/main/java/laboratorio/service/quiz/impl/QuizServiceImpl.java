// QuizServiceImpl.java
package laboratorio.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import laboratorio.model.quiz.DTO.Quiz.AnswerDTO;
import laboratorio.model.quiz.DTO.Quiz.QuestionDTO;
import laboratorio.model.quiz.DTO.Quiz.QuizDTO;
import laboratorio.model.quiz.Answer;
import laboratorio.model.quiz.Question;
import laboratorio.model.quiz.Quiz;
import laboratorio.repository.quiz.AnswerRepository;
import laboratorio.repository.quiz.QuestionRepository;
import laboratorio.repository.quiz.QuizRepository;
import laboratorio.service.quiz.QuizService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Quiz createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getQuizTitle());
        quiz.setVisibility(quizDTO.isVisibility());
        quiz.setCreated_at(java.time.LocalDateTime.now().toString());

        quiz = quizRepository.save(quiz);

        for (QuestionDTO questionDTO : quizDTO.getQuestions()) {
            Question question = new Question();
            question.setQuestion_text(questionDTO.getQuestionTitle());
            question.setVisibility(questionDTO.isVisibility());
            question.setQuiz_id(quiz);
            question.setCreated_at(java.time.LocalDateTime.now().toString());

            question = questionRepository.save(question);

            for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
                Answer answer = new Answer();
                answer.setAnswer_text(answerDTO.getText());
                answer.setIs_correct(answerDTO.getIsCorrect());
                answer.setQuestion(question);
                answer.setCreated_at(java.time.LocalDateTime.now().toString());
                answerRepository.save(answer);
            }
        }
        return quiz;
    }

    @Override
    public Quiz updateQuestion(Long questionId, QuestionDTO questionDTO) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        question.setQuestion_text(questionDTO.getQuestionTitle());
        question.setVisibility(questionDTO.isVisibility());

        questionRepository.save(question);

        // Updating answers
        for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
            Answer answer = answerRepository.findById(answerDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));

            answer.setAnswer_text(answerDTO.getText());
            answer.setIs_correct(answerDTO.getIsCorrect());
            answerRepository.save(answer);
        }

        return quizRepository.findById(question.getId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    @Override
    public void addQuestions(Long quizId, List<QuestionDTO> questionDTOs) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        for (QuestionDTO questionDTO : questionDTOs) {
            Question question = new Question();
            question.setQuestion_text(questionDTO.getQuestionTitle());
            question.setVisibility(questionDTO.isVisibility());
            question.setId(quiz.getId());
            question.setCreated_at(java.time.LocalDateTime.now().toString());

            question = questionRepository.save(question);

            for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
                Answer answer = new Answer();
                answer.setAnswer_text(answerDTO.getText());
                answer.setIs_correct(answerDTO.getIsCorrect());
                answer.setId(question.getId());
                answer.setCreated_at(java.time.LocalDateTime.now().toString());
                answerRepository.save(answer);
            }
        }
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public QuizDTO getQuizById(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuestionDTO> questionDTOs = quiz.getQuestions().stream().map(question -> {
            List<AnswerDTO> answerDTOs = question.getAnswers().stream().map(answer -> {
                return new AnswerDTO(answer.getId(), answer.getAnswer_text(), false); // false is a placeholder value
            }).collect(Collectors.toList());

            return new QuestionDTO(question.getId(), question.getQuestion_text(), question.getVisibility(), answerDTOs);
        }).collect(Collectors.toList());

        return new QuizDTO(quiz.getTitle(), quiz.getVisibility(), questionDTOs);
    }
}
