package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDto {

        private String questionTitle;   // 질문 제목

        private String questionContent;

        private String memberId; // 회원 아이디






}
