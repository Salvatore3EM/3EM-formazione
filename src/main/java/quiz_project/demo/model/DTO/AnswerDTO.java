package quiz_project.demo.model.DTO;

public class AnswerDTO {
    public String answer_text;
    public boolean is_correct;

    public AnswerDTO() {
    }

    public AnswerDTO(String answer_text, boolean is_correct) {
        this.answer_text = answer_text;
        this.is_correct = is_correct;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public boolean isIs_correct() {
        return is_correct;
    }

    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }

}
