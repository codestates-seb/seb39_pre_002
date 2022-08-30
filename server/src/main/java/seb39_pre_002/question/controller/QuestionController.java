package seb39_pre_002.questions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.questions.dto.QuestionsPatchDto;
import seb39_pre_002.questions.dto.QuestionsPostDto;
import seb39_pre_002.dto.SingleResponseDto;
import seb39_pre_002.questions.entity.Questions;
import seb39_pre_002.questions.mapper.QuestionsMapper;
import seb39_pre_002.questions.service.QuestionsService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    private final QuestionsMapper mapper;

    public QuestionsController(QuestionsService questionsService, QuestionsMapper mapper) {
        this.questionsService = questionsService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestions(@Valid @RequestBody QuestionsPostDto questionsPostDto) {

        Questions questions = questionsService.createQuestions(mapper.questionsPostDtoToQuestions(questionsPostDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionsToQuestionsResponse(questions)),
                HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity getQuestions() {
        List<Questions> questions = questionsService.findQuestions();

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionsToQuestionsResponseDto(questions)),HttpStatus.OK);
    }

    @PatchMapping("/{questions-id}")
    public ResponseEntity patchQuestions(@PathVariable("questions-id")@Positive long questionsId,
                                         @Valid @RequestBody QuestionsPatchDto questionsPatchDto) {
        questionsPatchDto.setQuestionsId(questionsId);

        Questions questions =
                questionsService.updateQuestions(mapper.questionsPatchToQuestions(questionsPatchDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionsToQuestionsResponse(questions)),HttpStatus.OK);

    }
    @DeleteMapping("/{questions-id}")
    public ResponseEntity deleteQuestions(@PathVariable("questions-id")@Positive long questionsId) {
        questionsService.deleteQuestions(questionsId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
