package quiz_project.demo.model.DTO;

import quiz_project.demo.model.Answer;

import java.util.List;

public class QuestionsDTO {
    String question_text;
    boolean visibility;
    List<AnswerDTO> Answer;

    public QuestionsDTO(String question_text, boolean visibility, List<AnswerDTO> answer) {
        this.question_text = question_text;
        this.visibility = visibility;
        Answer = answer;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public List<AnswerDTO> getAnswer() {
        return Answer;
    }

    public void setAnswer(List<AnswerDTO> answer) {
        Answer = answer;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
