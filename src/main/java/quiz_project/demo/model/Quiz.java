package quiz_project.demo.model;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "quiz_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Relazione OneToMany con le domande
    private List<Question> questions; // Lista di domande associate al quiz

    public Quiz() {
    }

    public Quiz(Long id, String title, boolean visibility, String created_at) {
        this.id = id;
        this.title = title;
        this.visibility = visibility;
        this.created_at = created_at;
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

    public String getCreated_at() {
        return created_at;
    }

    public Quiz setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
