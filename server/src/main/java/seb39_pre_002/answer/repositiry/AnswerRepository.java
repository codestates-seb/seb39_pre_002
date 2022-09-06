package seb39_pre_002.answer.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import seb39_pre_002.answer.entity.Answer;

import java.time.LocalDateTime;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
