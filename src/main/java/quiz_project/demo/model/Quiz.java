package quiz_project.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String created_at;



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

    public String getCreated_at() {
        return created_at;
    }

    public Quiz setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }
}