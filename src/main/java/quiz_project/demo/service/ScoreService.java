package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Score;
import quiz_project.demo.repository.ScoreRepository;

import java.util.List;

    @Service
    public class ScoreService {

        @Autowired
        private ScoreRepository scoreRepository;

        public List<Score> getAllScore() { return scoreRepository.findAll(); }

        public Score getScoreById(Long id) {
            return scoreRepository.findById(id).orElse(null);
        }

        public void editScoreById(Long id, Score NewScore) {
            Score OldScore = scoreRepository.findById(id).orElse(null);
            if(OldScore != null)
            {
                OldScore.setName(NewScore.getName());
                OldScore.setLastname(NewScore.getLastname());
                OldScore.setEmail(NewScore.getEmail());
                OldScore.setCreated_at(NewScore.getCreated_at());
            }
        }

        public Score saveScore (Score score) {
            return scoreRepository.save(score);
        }

        public void deleteScore(Long id) {
            scoreRepository.deleteById(id);
        }

    }

