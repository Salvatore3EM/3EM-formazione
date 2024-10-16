package quiz_project.demo.model.DTO;

import quiz_project.demo.model.Answer;

import java.util.List;

public class QuestionsDTO {
     public String answerTitle;
     public boolean visibility = true;
     public List<AnswerDTO> answers;

    public QuestionsDTO(){

    }

    public QuestionsDTO(String answerTitle, boolean visibility, List<AnswerDTO> answer) {
        this.answerTitle = answerTitle;
        this.visibility = visibility;
        this.answers = answer;
    }

    public String getQuestion_text() {
        return answerTitle;
    }

    public void setQuestion_text(String answerTitle) {
        this.answerTitle = answerTitle;
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
