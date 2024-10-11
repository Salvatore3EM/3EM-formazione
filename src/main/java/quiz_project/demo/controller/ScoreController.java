package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.Questions;
import quiz_project.demo.model.Score;
import quiz_project.demo.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() { return scoreService.getAllScore(); }

    @PostMapping("/submit")
    public Score createQuestion(@RequestBody Score score) {
        return scoreService.submitScore(score);
    }

}
