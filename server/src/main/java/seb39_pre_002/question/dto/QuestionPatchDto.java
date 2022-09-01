package seb39_pre_002.question.dto;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class QuestionPatchDto {

    private long questionId;

    private String questionTitle;   // 질문 제목

    private String questionContent; // 질문 등록

    private String memberId;





    public void setQuestionId(long questionsId) {
       this.questionId = questionsId;
   }

}
