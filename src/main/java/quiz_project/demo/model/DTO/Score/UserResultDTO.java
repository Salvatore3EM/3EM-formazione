package quiz_project.demo.model.DTO.Score;

public class UserResultDTO {
    private String name;
    private String lastname;
    private String email;
    private String date;
    private String quizTitle;
    private long correctAnswers;
    private long incorrectAnswers;

    public UserResultDTO(String name, String lastname, String email, String date, String quizTitle, long correctAnswers, long incorrectAnswers) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.date = date;
        this.quizTitle = quizTitle;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public long getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(long correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public long getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(long incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}