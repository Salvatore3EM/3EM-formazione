package quiz_project.demo.model.DTO;
import java.util.List;

public class QuizDTO {
    private String quizTitle;
    private boolean visibility = true;
    private List<QuestionsDTO> questions;

    public QuizDTO() {
    }

    public QuizDTO(String quizTitle, boolean visibility, List<QuestionsDTO> questions) {
        this.quizTitle = quizTitle;
        this.visibility = visibility;
        this.questions = questions;
    }

    public String getTitle() {
        return quizTitle;
    }

    public void setTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public List<QuestionsDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsDTO> questions) {
        this.questions = questions;
    }
}


