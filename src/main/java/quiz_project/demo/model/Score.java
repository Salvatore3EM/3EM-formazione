package quiz_project.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private String created_at;

    @ManyToOne
    Quiz quiz_id;

    @ManyToMany
    List<Answer> answers;

    public Score() {
    }

    public Score(Long id, String name, String lastname, String email, String created_at, Quiz quiz_id, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.created_at = created_at;
        this.quiz_id = quiz_id;
        this.answers = answers;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public Score setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Score setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Score setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Score setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Score setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public Quiz getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Quiz quiz_id) {
        this.quiz_id = quiz_id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}