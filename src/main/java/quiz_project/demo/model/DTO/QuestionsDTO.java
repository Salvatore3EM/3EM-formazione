package quiz_project.demo.model.DTO;

import quiz_project.demo.model.Answer;

import java.util.List;

public class QuestionsDTO {
     public String question_text;
     public boolean visibility;
     public List<AnswerDTO> answers;

    public QuestionsDTO(){

    }

    public QuestionsDTO(String question_text, boolean visibility, List<AnswerDTO> answer) {
        this.question_text = question_text;
        this.visibility = visibility;
        this.answers = answer;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
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
