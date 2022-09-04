package seb39_pre_002.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class AnswerDto {

    private long answerId;

    private long questionId;

    private String answerContent;

    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
