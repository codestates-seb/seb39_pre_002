package seb39_pre_002.question;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuestionPatchDto {

    private Long questionId;
    private String title;
    private String content;

    private String hashtag; //해시태크 나중에 하기
    private LocalDateTime createdAt; //질문시간기록
    private String memberName; // 질문자

    public void setquestionId(long questionId) {
        this.questionId = questionId;
    }

}
