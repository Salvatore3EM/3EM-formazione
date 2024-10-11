package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Answer;
import quiz_project.demo.model.DTO.AnswerDTO;
import quiz_project.demo.model.DTO.QuestionsDTO;
import quiz_project.demo.model.Questions;
import quiz_project.demo.model.Quiz;
import quiz_project.demo.repository.AnswersRepository;
import quiz_project.demo.repository.QuestionsRepository;
import quiz_project.demo.repository.QuizRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    private QuestionsRepository questionRepository;
    private AnswersRepository answerRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public void editQuizById(Long id, Quiz NewQuiz) {
        Quiz OldQuiz = quizRepository.findById(id).orElse(null);
        if(OldQuiz != null)
        {
            OldQuiz.setTitle(NewQuiz.getTitle());
            OldQuiz.setVisibility(NewQuiz.getVisibility());
            OldQuiz.setCreated_at(LocalDate.now().toString());
            quizRepository.save(OldQuiz);
        }
    }

    public Quiz saveQuiz (Quiz quiz) {
        quiz.setCreated_at(LocalDate.now().toString());
        return quizRepository.save(quiz);
    }

    public List<Quiz> saveQuizzes(List<Quiz> quizList) {
        List<Quiz> NewQuizList = new ArrayList<Quiz>();
        for (int i=0;i<quizList.size();i++)
        {
            Quiz quiz = quizList.get(i);
            quiz.setCreated_at(LocalDate.now().toString());
            NewQuizList.add(quiz);
            quizRepository.saveAll(NewQuizList);

        }

        return NewQuizList;
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public void toggleVisibilityQuizById (Long id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if(quiz.getVisibility()==true) {
            quiz.setVisibility(false);
            quizRepository.save(quiz);
        }
        else if (quiz.getVisibility()==false){
            quiz.setVisibility(true);
            quizRepository.save(quiz);
        }

    }

    public List<Quiz> AllQuizVisible() {
        List<Quiz> NewQuizList = new ArrayList<Quiz>();
        List<Quiz> Quizzes = quizRepository.findAll();
       for (int i=0;i<Quizzes.size();i++)
       {
           Quiz quiz = Quizzes.get(i);
           if(quiz.getVisibility()==true)
           {
               NewQuizList.add(quiz);
           }
       }
       return NewQuizList;
    }

    public Object addQuiz(int id_quiz, List<QuestionsDTO> questionList )
    {
//        List<Questions> NewQuestionsList = new ArrayList<Questions>();
//        List<Answer> NewAnswerList = new ArrayList<Answer>();
//        List<Object> addQuiz = new ArrayList<Object>();
//        for (int i=0;i<quizList.size();i++)
//        {
//            QuestionsDTO questionDTO = quizList.get(i);
//            Questions question = new Questions();
//            //question.setQuestion_text(questionDTO.getQuestion_text());
//            ///question.setVisibility(questionDTO.isVisibility());
//            question.setCreated_at(LocalDate.now().toString());
//            List<AnswerDTO> answerDTOList;
//            //answerDTOList = questionDTO.getAnswer();
//            //AnswerDTO answerDTO = answerDTOList.get(i);
//            Answer answer = new Answer();
//            answer.setAnswer_text(answerDTO.getAnswer_text());
//            answer.setIs_correct(answerDTO.isIs_correct());
//            answer.setCreated_at(LocalDate.now().toString());
//            NewQuestionsList.add(question);
//            questionRepository.saveAll(NewQuestionsList);
//            addQuiz.add(question);
//            NewAnswerList.add(answer);
//            answerRepository.saveAll(NewAnswerList);
//            addQuiz.add(answer);
        //}

       return null;
    }

}

