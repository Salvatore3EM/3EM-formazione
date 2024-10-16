package quiz_project.demo.model.DTO;

public class AnswerDTO {
    private Long answer_id;
    private String text;
    private boolean isCorrect;

    public AnswerDTO() {
    }

    public AnswerDTO(Long answer_id, String text, boolean isCorrect) {
        this.answer_id = answer_id;
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

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }
}
