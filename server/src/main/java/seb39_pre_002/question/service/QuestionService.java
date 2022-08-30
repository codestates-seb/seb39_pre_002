package seb39_pre_002.questions.service;


import org.springframework.stereotype.Service;
import seb39_pre_002.exception.BusinessLogicException;
import seb39_pre_002.exception.ExceptionCode;
import seb39_pre_002.questions.entity.Questions;
import seb39_pre_002.questions.repositiry.QuestionsRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {
    private final QuestionsRepository questionsRepository;

    public QuestionsService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    // 등록
    public Questions createQuestions(Questions questions) {

    questions.setCreatedAt(LocalDateTime.now());

        return questionsRepository.save(questions);
    }

    //전체 조회
    public List<Questions> findQuestions() {
        return (List<Questions>) questionsRepository.findAll();
    }
    // 수정
    public Questions updateQuestions(Questions questions){
        Optional.ofNullable(questions.getQuestionTitle())
                .ifPresent(questionTitle -> questions.setQuestionTitle(questionTitle));
        Optional.ofNullable(questions.getQuestionContent())
                .ifPresent(questionContent -> questions.setQuestionContent(questionContent));

        questions.setModifiedAt(LocalDateTime.now());

        return questionsRepository.save(questions);
    }
    // 삭제
    public void deleteQuestions(long questionsId) {

        Questions findQuestions = findVerifiedQuestions(questionsId);
        questionsRepository.delete(findQuestions);
    }

    //존재하는 질문인지 검증  이부분은 이해 불가 ㅠㅠ
    public Questions findVerifiedQuestions(long questionsId) {
        Optional<Questions> optionalQuestions =
                questionsRepository.findById(questionsId);
        Questions findQuestions = optionalQuestions.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTIONS_NOT_FOUND));

        return findQuestions;
    }
}
