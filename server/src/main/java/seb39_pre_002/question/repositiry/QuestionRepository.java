package seb39_pre_002.question.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import seb39_pre_002.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
