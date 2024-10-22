package quiz_project.demo.model.DTO.Quiz;

import java.util.List;

public class QuestionDTO {
    private Long id;
    public String questionTitle;
    public boolean visibility = true;
    public List<AnswerDTO> answers;

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String questionTitle, boolean visibility, List<AnswerDTO> answer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.visibility = visibility;
        this.answers = answer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
