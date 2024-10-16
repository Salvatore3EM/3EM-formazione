package quiz_project.demo.model.DTO;

import java.util.List;


public class ScoreDTO {
    private Long quiz_id;
    private String nome;
    private String cognome;
    private String email;
    private List<AnswerDTO> answers;

    public ScoreDTO() {
    }

    public ScoreDTO(Long quiz_id, String nome, String cognome, String email, List<AnswerDTO> answers) {
        this.quiz_id = quiz_id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.answers = answers;
    }

    public Long getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Long quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
