package seb39_pre_002.question.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.dto.QuestionPostDto;
import seb39_pre_002.response.MultiResponseDto;
import seb39_pre_002.response.SingleResponseDto;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.mapper.QuestionMapper;
import seb39_pre_002.question.service.QuestionService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto) {

        Question question = questionService.createQuestion(mapper.questionPostDtoToQuestion(questionPostDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponse(question)),
                HttpStatus.CREATED);

    }

    //전체 조회

    //    @GetMapping
//    public ResponseEntity getQuestions(@Positive @RequestParam int page,
//                                       @Positive @RequestParam int size) {
//
//        Page<Question> pageQuestions = questionService.findQuestions(page -1 , size);
//        List<Question> questions = pageQuestions.getContent();
//
//        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionToQuestionResponseDto(questions),pageQuestions),HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity getQuestions() {
        List<Question> questions = questionService.findQuestions();

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(questions)), HttpStatus.OK);
    }

    // ToDo 게시글 하나 조회
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(
            @PathVariable("question-id") @Positive long questionId) {
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponse(question)), HttpStatus.OK);

    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                        @Valid @RequestBody QuestionDto.Patch requestBody) {
        requestBody.setQuestionId(questionId);

        Question question =
                questionService.updateQuestion(mapper.questionPatchToQuestion(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponse(question)), HttpStatus.OK);

    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
