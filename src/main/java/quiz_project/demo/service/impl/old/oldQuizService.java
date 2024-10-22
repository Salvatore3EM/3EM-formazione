//package quiz_project.demo.service.impl.old;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import quiz_project.demo.model.Answer;
//import quiz_project.demo.model.DTO.Quiz.AnswerDTO;
//import quiz_project.demo.model.DTO.Quiz.QuestionDTO;
//import quiz_project.demo.model.DTO.Quiz.QuizDTO;
//import quiz_project.demo.model.Question;
//import quiz_project.demo.model.Quiz;
//import quiz_project.demo.repository.AnswersRepository;
//import quiz_project.demo.repository.QuestionsRepository;
//import quiz_project.demo.repository.QuizRepository;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class QuizService {
//
//    @Autowired
//    private QuizRepository quizRepository;
//    @Autowired
//    private QuestionsRepository questionRepository;
//    @Autowired
//    private AnswersRepository answerRepository;
//
//    public List<Quiz> getAllQuizzes() {
//        return quizRepository.findAll();
//    }
//
//    public Quiz getQuizById(Long id) {
//        return quizRepository.findById(id).orElse(null);
//    }
//
//    public void editQuizById(Long id, Quiz NewQuiz) {
//        Quiz OldQuiz = quizRepository.findById(id).orElse(null);
//        if(OldQuiz != null)
//        {
//            OldQuiz.setTitle(NewQuiz.getTitle());
//            OldQuiz.setVisibility(NewQuiz.getVisibility());
//            OldQuiz.setCreated_at(LocalDate.now().toString());
//            quizRepository.save(OldQuiz);
//        }
//    }
//
//    public Quiz saveQuiz (Quiz quiz) {
//        quiz.setCreated_at(LocalDate.now().toString());
//        return quizRepository.save(quiz);
//    }
//
//    public List<Quiz> saveQuizzes(List<Quiz> quizList) {
//        List<Quiz> NewQuizList = new ArrayList<Quiz>();
//        for (Quiz quiz : quizList) {
//            quiz.setCreated_at(LocalDate.now().toString());
//            NewQuizList.add(quiz);
//            quizRepository.saveAll(NewQuizList);
//        }
//
//        return NewQuizList;
//    }
//
//    public void deleteQuiz(Long id) {
//        quizRepository.deleteById(id);
//    }
//
//    public void toggleVisibilityQuizById (Long id) {
//        Quiz quiz = quizRepository.findById(id).orElse(null);
//        assert quiz != null;
//        if(quiz.getVisibility()) {
//            quiz.setVisibility(false);
//            quizRepository.save(quiz);
//        }
//        else {
//            quiz.setVisibility(true);
//            quizRepository.save(quiz);
//        }
//
//    }
//
//    public List<Quiz> AllQuizVisible() {
//        List<Quiz> NewQuizList = new ArrayList<Quiz>();
//        List<Quiz> Quizzes = quizRepository.findAll();
//        for (Quiz quiz : Quizzes) {
//            if (quiz.getVisibility()) {
//                NewQuizList.add(quiz);
//            }
//        }
//       return NewQuizList;
//    }
//
//    public boolean addQuiz(QuizDTO quiz )
//    {
//        List<Question> questions = new ArrayList<Question>();
//        List<Question> NewQuestion = new ArrayList<>();
//        List<Answer> answers = new ArrayList<Answer>();
//        QuestionDTO questionDTO = null;
//        List<QuestionDTO> questionsDTOList;
//        AnswerDTO answerDTO = null;
//        List<AnswerDTO> answerDTOList;
//        Quiz NewQuiz = new Quiz();
//
//        NewQuiz.setTitle(quiz.getQuizTitle());
//        NewQuiz.setVisibility(quiz.isVisibility());
//        NewQuiz.setCreated_at(LocalDate.now().toString());
//        quizRepository.save(NewQuiz);
//
//        questionsDTOList = quiz.getQuestions();
//
//        for (QuestionDTO questionsDTO : questionsDTOList) {
//            questionDTO = questionsDTO;
//
//            Question question = new Question();
//            question.setQuestion_text(questionDTO.getQuestionTitle());
//            question.setVisibility(questionDTO.isVisibility());
//            question.setCreated_at(LocalDate.now().toString());
//
//            question.setQuiz_id(quizRepository.findById(NewQuiz.getId()).orElse(null));
//
//            questionRepository.save(question);
//
//            answerDTOList = questionDTO.getAnswers();
//
//            for (AnswerDTO dto : answerDTOList) {
//                answerDTO = dto;
//
//                Answer answer = new Answer();
//                answer.setAnswer_text(answerDTO.getText());
//                answer.setIs_correct(answerDTO.getIsCorrect());
//                answer.setCreated_at(LocalDate.now().toString());
//                answer.setQuestion_id(questionRepository.findById(question.getId()).orElse(null));
//
//                answerRepository.save(answer);
//            }
//        }
//         return true;
//    }
//}