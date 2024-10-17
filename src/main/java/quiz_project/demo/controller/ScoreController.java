package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.DTO.ScoreDTO;
import quiz_project.demo.model.Score;
import quiz_project.demo.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScore();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitScore(@RequestBody ScoreDTO scoreDTO) {
        if(scoreService.submitScore(scoreDTO) != null)
        {
            return new ResponseEntity<>("Score saved with success", HttpStatus.OK);
        } else if (scoreService.submitScore(scoreDTO) == null) {
            return new ResponseEntity<>("answers to the same question is not possible", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
