package quiz_project.demo.model.DTO;

public class AnswerDTO {
    public String text;
    public boolean isCorrect;

    public AnswerDTO() {
    }

    public AnswerDTO(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getAnswer_text() {
        return text;
    }

    public void setAnswer_text(String text) {
        this.text = text;
    }

    public boolean isIs_correct() {
        return isCorrect;
    }

    public void setIs_correct(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}
