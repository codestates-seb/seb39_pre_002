package seb39_pre_002.questions.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import seb39_pre_002.questions.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}
