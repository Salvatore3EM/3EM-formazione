package laboratorio.model.quiz;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pins")
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin_text")
    private String pin_text;

    @Column(name = "start_time")
    private LocalDateTime start;

    @Column(name = "end_time")
    private LocalDateTime end;

    public Pin() {
    }

    public Pin(Long id, String pin_text, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.pin_text = pin_text;
        this.start = start;
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

    public void setPin_text(String pin_text) {
        this.pin_text = pin_text;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

}


