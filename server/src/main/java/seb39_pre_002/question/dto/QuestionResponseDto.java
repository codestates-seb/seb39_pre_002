package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seb39_pre_002.question.entity.Question;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class QuestionResponseDto {

    private Long questionId;
    private String questionTitle;
    private String questionContent;

    private String questionHashtag; //해시태크 나중에 하기
    private LocalDateTime createdAt; //질문시간기록 엔티티에 없을 때 실험
    private String memberName; // 질문자

//    private Question.QuestionStatus questionStatus;
//    public String getQuestionStatus() {
//        return questionStatus.getStatus();
    }

