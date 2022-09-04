package seb39_pre_002.answer.service;

import org.springframework.stereotype.Service;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.answer.repositiry.AnswerRepository;
import seb39_pre_002.exception.BusinessLogicException;
import seb39_pre_002.exception.ExceptionCode;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.service.QuestionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionService questionService;



    public AnswerService(AnswerRepository answerRepository,QuestionService questionService ) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;

    }

    // ToDo 답변 등록
    public Answer createAnswer(Answer answer) {

//        verifyAnswer(answer);
        answer.setCreatedAt(LocalDateTime.now());

        return answerRepository.save(answer);
    }

    // ToDo 답변 하나 조회
    public Answer findAnswer(long answerId) {
        return findVerifiedAnswer(answerId);
    }

    // ToDo 답변 전체 조회
    public List<Answer> findAnswers() {
        return (List<Answer>) answerRepository.findAll();
    }

    // ToDo 답변 수정
    public Answer updateAnswer(Answer answer) {
        Optional.ofNullable(answer.getAnswerContent())
                .ifPresent(answerContent -> answer.setAnswerContent(answerContent));

        answer.setModifiedAt(LocalDateTime.now());
        answer.getModifiedAt();
        return answerRepository.save(answer);
    }

    // ToDo 답변 삭제
    public void deleteAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);
        answerRepository.delete(findAnswer);
    }

//    private void verifyAnswer(Answer answer) {
//        questionService.findQuestion(answer.getQuestion().getQuestionId());
//    }


    // ToDo 존재하는 답변인지 검증  이부분은 이해 불가 ㅠㅠ
    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTIONS_NOT_FOUND));

        return findAnswer;

    }
}
