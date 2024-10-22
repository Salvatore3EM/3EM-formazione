package quiz_project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz_project.demo.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
