package seb39_pre_002.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionsResponseDto {
    private Long questionsId;

    private String questionTitle;   // 질문 제목

    private String questionContent;
}
