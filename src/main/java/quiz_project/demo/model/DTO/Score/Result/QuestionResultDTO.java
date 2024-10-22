package quiz_project.demo.model.DTO.Score.Result;

import java.util.List;

public class QuestionResultDTO {
    private Long id;
    private String questionTitle;
    private List<AnswerResultDTO> answers;

    public QuestionResultDTO(String questionTitle, Long id, List<AnswerResultDTO> answers) {
        this.questionTitle = questionTitle;
        this.id = id;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public List<AnswerResultDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResultDTO> answers) {
        this.answers = answers;
    }
}