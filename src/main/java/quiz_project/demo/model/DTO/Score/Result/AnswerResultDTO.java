package quiz_project.demo.model.DTO.Score.Result;

public class AnswerResultDTO {
    private Long id;
    private String text;
    private boolean isCorrect;
    private boolean isUserChoice;  // Aggiunta del flag

    public AnswerResultDTO(Long id, String text, boolean isCorrect, boolean isUserChoice) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
        this.isUserChoice = isUserChoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isUserChoice() {
        return isUserChoice;
    }

    public void setUserChoice(boolean userChoice) {
        isUserChoice = userChoice;
    }
}