package quiz_project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String question_text;

    @Column(name = "visibility")
    private boolean visibility;

    @Column(name = "created_at")
    private String created_at;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz_id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question() {
    }

    public Question(Long id, String question_text, boolean visibility, String created_at, Quiz quiz) {
        this.id = id;
        this.question_text = question_text;
        this.visibility = visibility;
        this.created_at = created_at;
        this.quiz_id = quiz;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Question setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public Question setQuestion_text(String question_text) {
        this.question_text = question_text;
        return this;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public Question setVisibility(boolean visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Question setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public Quiz getQuiz_id() {  // Cambiato da getQuiz_id a getQuiz
        return quiz_id;
    }

    public Question setQuiz_id(Quiz quiz_id) {  // Cambiato da setQuiz_id a setQuiz
        this.quiz_id = quiz_id;
        return this;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
