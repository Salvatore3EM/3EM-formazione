package quiz_project.demo.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "pins")
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin_text")
    private String pin_text;

    @Column(name = "start")
    private LocalDate start;

    @Column(name = "end")
    private LocalDate end;

    //Constructor

    public Pin(LocalDate start, Long id, String pin_text, LocalDate end) {
        this.start = start;
        this.id = id;
        this.pin_text = pin_text;
        this.end = end;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public Pin setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPin_text() {
        return pin_text;
    }

    public Pin setPin_text(String pin_text) {
        this.pin_text = pin_text;
        return this;
    }

    public LocalDate getStart() {
        return start;
    }

    public Pin setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Pin setEnd(LocalDate end) {
        this.end = end;
        return this;
    }

}
