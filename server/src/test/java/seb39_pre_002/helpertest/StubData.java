package seb39_pre_002.helpertest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpMethod;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.entity.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class StubData {
    private static Map<HttpMethod, Object> stubRequestBody;

    static {
        stubRequestBody = new HashMap<>();
        stubRequestBody.put(HttpMethod.POST, new QuestionDto.Post("test1Title", "test1Content", "hashtag바디"));
        stubRequestBody.put(HttpMethod.PATCH, new QuestionDto.Patch(1L, "test1Title", "test1Content", "hashtag바디"));
    }


    public static class MockQuestion {
        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }


        public static QuestionDto.Response getSingleResponseBody() {
            return new QuestionDto.Response(1L,
                    "test1Title", "test1Content", "hashtag바디");
        }

        public static List<QuestionDto.Response> getMultiResponseBody() {
            return List.of(
                    new QuestionDto.Response(1L,
                            "test1Title", "test1Content", "hashtag바디"),
                    new QuestionDto.Response(2L,
                            "test2Title", "test2Content", "hashtag바디2"),
                    new QuestionDto.Response(3L,
                            "test3Title", "test3Content", "hashtag바디3"),
                    new QuestionDto.Response(4L,
                            "test4Title", "test4Content", "hashtag바디4"),
                    new QuestionDto.Response(5L,
                            "test5Title", "test5Content", "hashtag바디5"),
                    new QuestionDto.Response(6L,
                            "test6Title", "test6Content", "hashtag바디6")

            );
        }
    }

//    public static Question getSingleResultQuestion() {
//        Question question = new Question("테스트용제목입니다", "이것은 테스트용 첫번째 내용입니다", "해시태그테스트");
//        return question;
//    }

    public static Page<Question> getMultiResultQuestion() {
        Question question1 = new Question("test1Title", "test1Content", "hashtag바디1");
        Question question2 = new Question("test2Title", "test2Content", "hashtag바디2");
        Question question3 = new Question("test3Title", "test3Content", "hashtag바디3");
        Question question4 = new Question("test4Title", "test4Content", "hashtag바디4");
        Question question5 = new Question("test5Title", "test5Content", "hashtag바디5");
        Question question6 = new Question("test6Title", "test6Content", "hashtag바디6");


        return new PageImpl<>(List.of(question1, question2, question3, question4, question5, question6),
                PageRequest.of(0, 5, Sort.by("memberId").descending()),
                2);
    }
}

//        public static Question getSingleResultQuestion(long questionId) {
//            Question question = new Question("test1Title", "test1Content", "hashtag바디1");
//            question.setQuestionId(questionId);
//             return question;
//        }
////
//        public static Question getSingleResultQuestion(long questionId, Map<String, String> updatedInfo) {
//            String content = Optional.ofNullable(updatedInfo.get("content")).orElse("이것은 테스트용 첫번째 내용입니다");
//            String hashtag = Optional.ofNullable(updatedInfo.get("hashtag")).orElse("해시태그테스트");
//            Question question = new Question("테스트용 첫번째 제목입니다", content, hashtag);
//            question.setQuestionId(questionId);
////            question.setQuestionStatus(Question.QuestionStatus.Question_Create);
//            return question;
//        }
//    }
//}
