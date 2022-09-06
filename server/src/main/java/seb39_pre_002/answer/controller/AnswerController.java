package seb39_pre_002.answer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.answer.dto.AnswerDto;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.answer.mapper.AnswerMapper;
import seb39_pre_002.answer.repositiry.AnswerRepository;
import seb39_pre_002.answer.service.AnswerService;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.repositiry.QuestionRepository;
import seb39_pre_002.question.service.QuestionService;
import seb39_pre_002.response.SingleResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/questions/{question-id}/answers")
public class AnswerController {

    private final QuestionService questionService;

    private final QuestionRepository questionRepository;

    private final AnswerService answerService;

    private final AnswerMapper mapper;

    private final AnswerRepository answerRepository;

    public AnswerController(AnswerService answerService, AnswerMapper mapper, QuestionService questionService, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.answerService = answerService;
        this.mapper = mapper;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @PostMapping("")
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId, @Valid @RequestBody AnswerDto answerPostDto) {


        Answer answer = answerService.createAnswer(questionId, mapper.answerPostDtoToAnswer(answerPostDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.answerToAnswerDtoResponse(answer)), HttpStatus.CREATED);

    }

    @GetMapping("")
    public ResponseEntity getAnswers(@PathVariable("question-id") @Positive long questionId) {
        List<Answer> answers = answerService.findAnswers();

        return new ResponseEntity(new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answers)), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(
            @PathVariable("question-id") @Positive long questionId,
            @PathVariable("answer-id") @Positive long answerId) {
        Answer answer = answerService.findAnswer(answerId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.answerToAnswerDtoResponse(answer)), HttpStatus.OK);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(
            @PathVariable("question-id") @Positive long questionId,
            @PathVariable("answer-id") @Positive long answerId,
            @Valid @RequestBody AnswerDto requestBody) {
        requestBody.setAnswerId(answerId);

        Answer answer =
                answerService.updateAnswer(questionId,mapper.answerPatchToAnswer(requestBody));


        return new ResponseEntity(new SingleResponseDto<>(mapper.answerToAnswerDtoResponse(answer)), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(
            @PathVariable("question-id") @Positive long questionId,
            @PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
