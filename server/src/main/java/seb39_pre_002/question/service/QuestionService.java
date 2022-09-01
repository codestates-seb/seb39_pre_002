package seb39_pre_002.question.service;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import seb39_pre_002.exception.BusinessLogicException;
import seb39_pre_002.exception.ExceptionCode;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.repositiry.QuestionRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ApplicationEventPublisher publisher;

    public QuestionService(QuestionRepository questionRepository,
                           ApplicationEventPublisher publisher) {
        this.questionRepository = questionRepository;
        this.publisher = publisher;
    }

    // 등록
    public Question createQuestion(Question question) {

        question.setCreatedAt(LocalDateTime.now());

        return questionRepository.save(question);
    }
    //질문 하나 조회
    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    //전체 조회
    public Page<Question> findQuestions(int page, int size) {

        return questionRepository.findAll(PageRequest.of(page, size,Sort.by("questionId").ascending()));
    }
    // 수정

    public Question updateQuestion(Question question){
        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(questionTitle -> question.setQuestionTitle(questionTitle));
        Optional.ofNullable(question.getQuestionContent())
                .ifPresent(questionContent -> question.setQuestionContent(questionContent));


        question.setModifiedAt(LocalDateTime.now());

        return questionRepository.save(question);
    }
    // 삭제
    public void deleteQuestion(long questionId) {

        Question findQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    //존재하는 질문인지 검증  이부분은 이해 불가 ㅠㅠ
    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTIONS_NOT_FOUND));

        return findQuestion;
    }
}
