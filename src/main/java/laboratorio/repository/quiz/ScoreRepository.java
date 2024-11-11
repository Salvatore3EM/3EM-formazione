package laboratorio.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import laboratorio.model.quiz.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
