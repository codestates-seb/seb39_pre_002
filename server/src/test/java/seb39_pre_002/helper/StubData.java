//package seb39_pre_002.helper;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpMethod;
//import seb39_pre_002.question.dto.QuestionDto;
//import seb39_pre_002.question.entity.Question;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class StubData {
//    private static Map<HttpMethod, Object> stubRequestBody;
//
//    static {
//        stubRequestBody = new HashMap<>();
//        stubRequestBody.put(HttpMethod.POST, new QuestionDto.Post("제목", "내용", "작성자ID"));
//        stubRequestBody.put(HttpMethod.PATCH, new QuestionDto.Patch(1L, "제목", "내용", "작성자ID"));
//    }
//
//    public static class MockQuestion {
//        public static Object getRequestBody(HttpMethod method) {
//            return stubRequestBody.get(method);
//        }
//
//        public static QuestionDto.Response getSingleResponseBody() {
//            return new QuestionDto.Response(1L,
//                    "제목",
//                    "내용",
//                    "작성자ID");
//        }
//
//
//        public static List<QuestionDto.Response> getMultiResponseBody() {
//            return List.of(
//                    new QuestionDto.Response(1L,
//                            "제목",
//                            "내용",
//                            "작성자id"),
//                    new QuestionDto.Response(2L,
//                            "제목1",
//                            "내용2",
//                            "작정사Id")
//
//            );
//        }
//
//        public static Question getSingleResultMember() {
//            Question question = new Question("제목", "내용", "작성자Id");
//
//            return question;
//        }
//
//        public static Page<Question> getMultiResultMember() {
//            Question question1 = new Question("제목", "내용", "작성자Id");
//
//            Question question2 = new Question("제목1", "내용1", "작성자Id");
//
//            return new PageImpl<>(List.of(question1, question2),
//                    PageRequest.of(0, 10, Sort.by("questionId").descending()), 2);
//        }
//
//        public static Question getSingleResultMember(long questionId) {
//            Question question = new Question("제목", "내용", "작성자Id");
//            question.setQuestionId(questionId);
//            return question;
//        }
//
//        public static Question getSingleResultMember(long questionId, Map<String, String> updatedInfo) {
//            String questionTitle = Optional.ofNullable(updatedInfo.get("questionTitle")).orElse("제목");
//            String questionContent = Optional.ofNullable(updatedInfo.get("questionContent")).orElse("내용");
//            Question question = new Question(questionTitle, questionContent, "작성자Id");
//            question.setQuestionId(questionId);
//
//            return question;
//        }
//
//    }
//}
//
//
