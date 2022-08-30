package seb39_pre_002.answer.entity;

import seb39_pre_002.question.entity.Question;

import java.time.LocalDateTime;

public class Answer {
   private long answersId;
   private Question questionId; //질문자 - ID
   private String title;
   private String context;

   private LocalDateTime createdAt; //답변등록기록
   private String memberName; // 답변자


}
