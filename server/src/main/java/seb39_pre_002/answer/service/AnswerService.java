package seb39_pre_002.answer.service;

import org.springframework.stereotype.Service;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.answer.repositiry.AnswerRepository;
import seb39_pre_002.exception.BusinessLogicException;
import seb39_pre_002.exception.ExceptionCode;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.repositiry.QuestionRepository;
import seb39_pre_002.question.service.QuestionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionService questionService;

    private final QuestionRepository questionRepository;



    public AnswerService(AnswerRepository answerRepository,QuestionService questionService, QuestionRepository questionRepository ) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.questionRepository = questionRepository;

    }

    // ToDo 답변 등록
    public Answer createAnswer(long questionId,Answer answer) {

//        Question findQuestionId = questionService.findVerifiedQuestion(answer.getQuestion().getQuestionId());
//        answer.setQuestion();
        Question question = questionRepository.findById(questionId).orElseThrow(()-> {
            return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 아이디를 찾을 수 없음");
        });
        answer.setQuestion(question);
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

//    private void verifyAnswer(Question question) {
//        questionService.findQuestion(question.getQuestionId());
//    }


//    // ToDo 존재하는 답변인지 검증  이부분은 이해 불가 ㅠㅠ
//    public Question findVerifiedQuestion(long questionId) {
//        Optional<Question> optionalAnswer =
//                questionRepository.findById(questionId);
//        Question findAnswer = optionalAnswer.orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.QUESTIONS_NOT_FOUND));
//
//        return findAnswer;
//
//    }

    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTIONS_NOT_FOUND));

        return findAnswer;

    }
}
