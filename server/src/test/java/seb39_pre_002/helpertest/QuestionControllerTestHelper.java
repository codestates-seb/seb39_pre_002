package seb39_pre_002.helpertest;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.ParameterDescriptor;

import java.util.Arrays;
import java.util.List;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;

public interface QuestionControllerTestHelper extends ControllerTestHelper {
        String QUESTION_URL = "/v1/questions";
        String RESOURCE_URI = "/{question-id}";

        default String getUrl() {
            return QUESTION_URL;
        }

        default String getURI() {
            return QUESTION_URL + RESOURCE_URI;
        }

        default List<ParameterDescriptor> getQuestionRequestPathParameterDescriptor() {
            return Arrays.asList(parameterWithName("question-id").description("질문 식별자 ID"));
        }

        default List<FieldDescriptor> getDefaultQuestionPostRequestDescriptors() {

            return List.of(
                    fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                    fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
                    fieldWithPath("hashtag").type(JsonFieldType.STRING).description("해시태그")
            );
        }

        default List<FieldDescriptor> getDefaultQuestionPatchRequestDescriptors() {

            return List.of(
                    fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                    fieldWithPath("title").type(JsonFieldType.STRING).description("제목").optional(),
                    fieldWithPath("hashtag").type(JsonFieldType.STRING).description("해시태그").optional()
//                    fieldWithPath("questionStatus").type(JsonFieldType.STRING)
//                            .description("질문 상태: Question_Create(작성) / Question_modify(수정), / Question_Delete(삭제) / Question_completion(완료)").optional()
            );
        }

        default List<FieldDescriptor> getDefaultQuestionResponseDescriptors(DataResponseType dataResponseType) {
            String parentPath = getDataParentPath(dataResponseType);
            return List.of(
                    fieldWithPath(parentPath.concat("questionId")).type(JsonFieldType.NUMBER).description("질문 식별자"),
                    fieldWithPath(parentPath.concat("title")).type(JsonFieldType.STRING).description("제목"),
                    fieldWithPath(parentPath.concat("content")).type(JsonFieldType.STRING).description("내용"),
                    fieldWithPath(parentPath.concat("hashtag")).type(JsonFieldType.STRING).description("해시태그"),
                    fieldWithPath(parentPath.concat("questionStatus")).type(JsonFieldType.STRING)
                            .description("질문 상태: Question_Create(작성) / Question_modify(수정), / Question_Delete(삭제) / Question_completion(완료)")
            );
        }
    }
