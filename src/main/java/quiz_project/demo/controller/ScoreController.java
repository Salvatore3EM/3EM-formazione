package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Score;
import quiz_project.demo.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllQuizzes() { return scoreService.getAllScore(); }

    @GetMapping("/{id}")
    public Score getQuizById (@PathVariable Long id) { return scoreService.getScoreById(id); }

    @PutMapping("/{id}")
    public void editScoreById (@PathVariable Long Id, @RequestBody Score NewScore) {
        scoreService.editScoreById(Id,NewScore);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore (@PathVariable Long id) {
        scoreService.deleteScore(id);
    }
}
