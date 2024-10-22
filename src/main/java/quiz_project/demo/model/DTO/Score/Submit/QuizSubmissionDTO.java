package quiz_project.demo.model.DTO.Score.Submit;

import java.util.List;

public class QuizSubmissionDTO {
    private String name;
    private String lastname;
    private String email;
    private Long quizId;
    private List<SubmittedAnswerDTO> answers;

    public QuizSubmissionDTO() {
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

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<SubmittedAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SubmittedAnswerDTO> answers) {
        this.answers = answers;
    }
}