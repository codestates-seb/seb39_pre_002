package seb39_pre_002.question;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.member.memberPatchDto;
import seb39_pre_002.member.memberPostDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/question")
@Validated

//@Slf4j
public class questioncontroller {

    @PostMapping
    public ResponseEntity postquestion(@Valid @RequestBody questionPostDto questionDto) {
        return new ResponseEntity<>(questionDto, HttpStatus.CREATED);

    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchquestion(@PathVariable("question-id") @Positive long questionId,
                                      @Valid @RequestBody questionPatchDto questionPatchDto) {
       questionPatchDto.setquestionId(questionId);

        return new ResponseEntity<>(questionPatchDto, HttpStatus.OK);
    }


    @GetMapping("/{question-id}")
    public ResponseEntity getMember(@PathVariable("question-id") @Positive long questionId) {
        System.out.println("# questionId: " + questionId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getquestions() {
        System.out.println("# get questions");

        // not implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteMember(@PathVariable("question-id") @Positive long questionId) {
        System.out.println("# questionId: " + questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
