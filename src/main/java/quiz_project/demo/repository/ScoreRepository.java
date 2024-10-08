package quiz_project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz_project.demo.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
