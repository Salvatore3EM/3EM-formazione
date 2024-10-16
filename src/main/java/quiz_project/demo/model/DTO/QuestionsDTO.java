package quiz_project.demo.model.DTO;

import java.util.List;

public class QuestionsDTO {
    private String questionTitle;
    private boolean visibility = true;
    private List<AnswerDTO> answers;

    public QuestionsDTO() {

    }

    public QuestionsDTO(String questionTitle, boolean visibility, List<AnswerDTO> answer) {
        this.questionTitle = questionTitle;
        this.visibility = visibility;
        this.answers = answer;
    }

    public String getQuestion_text() {
        return questionTitle;
    }

    public void setQuestion_text(String answerTitle) {
        this.questionTitle = questionTitle;
    }

    public List<AnswerDTO> getAnswer() {
        return answers;
    }

    public void setAnswer(List<AnswerDTO> answer) {
        answers = answer;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
