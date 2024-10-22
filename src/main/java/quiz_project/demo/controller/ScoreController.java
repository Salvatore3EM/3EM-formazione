package quiz_project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz_project.demo.model.DTO.Score.Result.QuizResultDTO;
import quiz_project.demo.model.DTO.Score.Submit.QuizSubmissionDTO;
import quiz_project.demo.model.DTO.Score.UserResultDTO;
import quiz_project.demo.model.Score;
import quiz_project.demo.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/submit")
    public ResponseEntity<Score> submitQuiz(@RequestBody QuizSubmissionDTO submissionDTO) {
        Score score = scoreService.submitQuiz(submissionDTO);
        return ResponseEntity.ok(score);
    }

    // Endpoint per ottenere i risultati aggregati di tutti gli utenti
    @GetMapping("/results")
    public ResponseEntity<List<UserResultDTO>> getAllUserResults() {
        List<UserResultDTO> results = scoreService.getAllUserResults();
        return ResponseEntity.ok(results);
    }

    // Endpoint per ottenere i dettagli di un singolo punteggio
    @GetMapping("/{scoreId}")
    public ResponseEntity<QuizResultDTO> getScoreDetailsById(@PathVariable Long scoreId) {
        QuizResultDTO scoreDetails = scoreService.getScoreDetailsById(scoreId);
        return ResponseEntity.ok(scoreDetails);
    }
}
