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
    private LocalDateTime created_at;

    @ManyToOne
    Quiz quiz_id;

    @ManyToMany
    List<Answer> answer_id;

    public Score() {
    }

    public Score(Long id, String name, String lastname, String email, LocalDateTime created_at, Quiz quiz_id, List<Answer> answer_id) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.created_at = created_at;
        this.quiz_id = quiz_id;
        this.answer_id = answer_id;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Score setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
        return this;
    }

}