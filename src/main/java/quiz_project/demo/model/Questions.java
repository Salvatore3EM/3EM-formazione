package quiz_project.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions")
public class Questions {

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
    Quiz quiz_id;

    @OneToMany
    Answer answers;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Questions setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public Questions setQuestion_text(String question_text) {
        this.question_text = question_text;
        return this;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public Questions setVisibility(boolean visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Questions setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public Quiz getQuiz_id() {
        return quiz_id;
    }

    public Questions setQuiz_id(Quiz quiz_id) {
        this.quiz_id = quiz_id;
        return this;
    }
}
