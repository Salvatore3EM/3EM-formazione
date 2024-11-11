package laboratorio.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import laboratorio.model.quiz.DTO.Score.Result.QuizResultDTO;
import laboratorio.model.quiz.DTO.Score.Submit.QuizSubmissionDTO;
import laboratorio.model.quiz.DTO.Score.UserResultDTO;
import laboratorio.model.quiz.Score;
import laboratorio.service.quiz.ScoreService;

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
