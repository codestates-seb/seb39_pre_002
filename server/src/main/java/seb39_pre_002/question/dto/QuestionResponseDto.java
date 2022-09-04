package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class QuestionResponseDto {
    private long questionId;

    private String questionTitle;   // 질문 제목

    private String questionContent;

    private String questionHashtag;

    private String username; // 회원 아이디

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


}
