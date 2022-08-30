package seb39_pre_002.questions.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class QuestionsPatchDto {

    private Long questionsId;

    private String questionTitle;   // 질문 제목

    private String questionContent; // 질문 등록




    public void setQuestionsId(long questionsId) {
       this.questionsId = questionsId;
   }

}
