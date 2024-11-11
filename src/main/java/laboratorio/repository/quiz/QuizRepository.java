package laboratorio.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import laboratorio.model.quiz.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
