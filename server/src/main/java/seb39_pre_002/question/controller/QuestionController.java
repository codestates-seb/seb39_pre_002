package seb39_pre_002.question.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.dto.QuestionResponseDto;
import seb39_pre_002.question.mapper.QuestionMapper;
import seb39_pre_002.question.dto.QuestionPatchDto;
import seb39_pre_002.question.dto.QuestionPostDto;
import seb39_pre_002.question.service.QuestionService;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.dto.MultiResponseDto;
import seb39_pre_002.dto.SingleResponseDto;


import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/questions")
@Validated //유효성 검증 - dto에서 아직 안 넣음
@Slf4j
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody) {

        Question question = questionMapper.questionPostToQuestion(requestBody);

        Question createQuestion = questionService.createQuestion(question);

        QuestionDto.Response response = questionMapper.questionToQuestionResponse(createQuestion);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response), HttpStatus.CREATED);
//              new SingleResponseDto(questionMapper.questionToQuestionResponseDto(createQuestion)), HttpStatus.CREATED);
    }


    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(
            @PathVariable("question-id") @Positive long questionId,
            @Valid @RequestBody QuestionDto.Patch requestBody) {
       requestBody.setQuestionId(questionId);

       Question question =
               questionService.updateQuestion(questionMapper.questionPatchToQuestion(requestBody));

        return new ResponseEntity<>(
                new SingleResponseDto(questionMapper.questionToQuestionResponse(question)), HttpStatus.OK);
    }


    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive long questionId) {
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(
                new SingleResponseDto(questionMapper.questionToQuestionResponse(question)),HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);
        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(questionMapper.questionsToQuestionResponses(questions),
                        pageQuestions),
                HttpStatus.OK);
    }

//    public ResponseEntity getQuestions() {
//        List<Question> Questions = questionservice.findQuestions();
//        List<QuestionResponseDto> dto =
//                Questions.stream()
//                        .map(question -> questionMapper.questionToquestionResponseDto(question))
//                        .collect(Collectors.toList());
//
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }


    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        System.out.println("# delete question");
        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
