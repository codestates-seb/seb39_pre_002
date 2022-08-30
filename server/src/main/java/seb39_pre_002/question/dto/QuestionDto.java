package seb39_pre_002.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seb39_pre_002.member.entity.Member;
import seb39_pre_002.question.entity.Question;

public class QuestionDto {
    @Getter
    @AllArgsConstructor // 테스트를 위해 추가
    public static class Post {

        private String title;

        private String content;

        private String hashtag;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long questionId;

        private String title;

        private String content;

        private String hashtag;

//        private Question.QuestionStatus questionStatus;


        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long questionId;
        private String title;
        private String content;
        private String hashtag;
//        private Question.QuestionStatus questionStatus;
//
//        public String getQuestionStatus() {
//            return questionStatus.getStatus();
//        }
//    }
    }
}
