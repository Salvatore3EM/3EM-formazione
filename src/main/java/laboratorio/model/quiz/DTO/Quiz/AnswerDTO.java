package laboratorio.model.quiz.DTO.Quiz;

public class AnswerDTO {
    private Long id;
    private String text;
    private boolean isCorrect;

    public AnswerDTO() {
    }

    public AnswerDTO(Long id, String text, boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
