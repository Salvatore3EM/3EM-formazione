package laboratorio.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import laboratorio.model.quiz.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
}
