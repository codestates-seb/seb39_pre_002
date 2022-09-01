package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class QuestionDto {
    @Getter
    @AllArgsConstructor // TODO 테스트를 위해 추가됨
    public static class Post {

        private String questionTitle;   // 질문 제목

        private String questionContent;

        private String memberId; // 회원 아이디
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {

        private long questionId;

        private String questionTitle;   // 질문 제목

        private String questionContent; // 질문 등록

        private String memberId;


        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long questionId;

        private String questionTitle;   // 질문 제목

        private String questionContent;

        private String memberId; // 회원 아이디
    }

}