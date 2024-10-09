package quiz_project.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "visibility")
    private boolean visibility;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @ManyToOne
    Questions questions;

    @ManyToOne
    Score scores;

    public Quiz() {
    }

    public Quiz(Long id, String title, boolean visibility, LocalDateTime created_at, Questions questions, Score scores) {
        this.id = id;
        this.title = title;
        this.visibility = visibility;
        this.created_at = created_at;
        this.questions = questions;
        this.scores = scores;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Quiz setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Quiz setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public Quiz setVisibility(boolean visibility) {
        this.visibility = visibility;
        return this;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Quiz setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
        return this;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Score getScores() {
        return scores;
    }

    public void setScores(Score scores) {
        this.scores = scores;
    }
}