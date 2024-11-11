package laboratorio.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import laboratorio.model.quiz.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
