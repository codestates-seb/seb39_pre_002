package seb39_pre_002.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seb39_pre_002.question.entity.Question;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//    Optional<Question> findByQuestion(Long questionId);

//    @Query(value = "SELECT c FROM Question c WHERE c.questionId = :questionId")
//    Optional<Question> findByQuestion(Long questionId);

}
