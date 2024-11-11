package laboratorio.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import laboratorio.model.quiz.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
