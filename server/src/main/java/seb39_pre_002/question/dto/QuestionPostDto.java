package seb39_pre_002.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsPostDto {

        private String questionTitle;   // 질문 제목

        private String questionContent;





}
