package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seb39_pre_002.member.entity.Member;
import seb39_pre_002.question.entity.Question;

public class QuestionDto {
    @Getter
    @AllArgsConstructor // 테스트를 위해 추가
    public static class Post {

        private String questionTitle;

        private String questionContent;

        private String questionHashtag;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long questionId;

        private String questionTitle;

        private String questionContent;

        private String questionHashtag;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long questionId;
        private String questionTitle;
        private String questionContent;
        private String questionHashtag;


    }
}
