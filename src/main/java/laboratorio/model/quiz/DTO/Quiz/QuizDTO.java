package laboratorio.model.quiz.DTO.Quiz;

import java.util.List;

public class QuizDTO {
    private String quizTitle;
    private boolean visibility;
    private List<QuestionDTO> questions;

    public QuizDTO() {
    }

    public QuizDTO(String quizTitle, boolean visibility, List<QuestionDTO> questions) {
        this.quizTitle = quizTitle;
        this.visibility = visibility;
        this.questions = questions;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}