package laboratorio.model.quiz.DTO.Score.Result;

import java.util.List;

public class QuizResultDTO {
    private String quizTitle;
    private String name;
    private String lastname;
    private String email;
    private String date;
    private List<QuestionResultDTO> questions;

    public QuizResultDTO(String quizTitle, String name, String lastname, String email, String date, List<QuestionResultDTO> questions) {
        this.quizTitle = quizTitle;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.date = date;
        this.questions = questions;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<QuestionResultDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionResultDTO> questions) {
        this.questions = questions;
    }
}