package seb39_pre_002.question.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import seb39_pre_002.exception.BusinessLogicException;
import seb39_pre_002.exception.ExceptionCode;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.repository.QuestionRepository;

import java.util.Optional;


//질문서비스 고민필요
//기본구성은 등록, 수정, 삭제 .... 조회
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    //등록
    public Question createQuestion(Question question) {

        Question savedQuestion = questionRepository.save(question);

        return savedQuestion;
    }


    //수정
//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Question updateQuestion(Question question) {
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(questionTitle -> question.setQuestionTitle(questionTitle));
        Optional.ofNullable(question.getQuestionContent())
                .ifPresent(questionContent -> question.setQuestionContent(questionContent));

//        Optional.ofNullable(question.getQuestionStatus())
//                .ifPresent(questionStatus -> question.setQuestionStatus(questionStatus));
//        findQuestion.setModifiedAt(LocalDateTime.now());

        return questionRepository.save(question);
    }

    //단일조회
    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }


    //조회
    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size,
                Sort.by("questionId").descending()));
    }


    //삭제
    public void deleteQuestion(long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findQuestion);
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion =
                optionalQuestion.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.Question_NOT_FOUND));
        return findQuestion;
    }
}
