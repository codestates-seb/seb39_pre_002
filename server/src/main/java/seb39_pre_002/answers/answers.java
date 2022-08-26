package seb39_pre_002.answers;

import seb39_pre_002.question.question;

import java.time.LocalDateTime;

public class answers {
   private long answersId;
   private question questionId; //질문자 - ID
   private String title;
   private String context;

    private LocalDateTime createdAt; //답변등록기록
    private String memberName; // 답변자


}
