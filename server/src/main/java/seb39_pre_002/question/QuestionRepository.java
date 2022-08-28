package seb39_pre_002.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//    Optional<Question> findByQuestion(Long questionId);

//    @Query(value = "SELECT c FROM Question c WHERE c.questionId = :questionId")
//    Optional<Question> findByQuestion(Long questionId);

}
