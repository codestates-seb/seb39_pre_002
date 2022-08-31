package seb39_pre_002.mocktest;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import seb39_pre_002.helpertest.QuestionControllerTestHelper;
import seb39_pre_002.helpertest.StubData;
import seb39_pre_002.question.controller.QuestionController;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.entity.Question;
import seb39_pre_002.question.mapper.QuestionMapper;
import seb39_pre_002.question.service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static seb39_pre_002.util.ApiDocumentUtils.getRequestPreProcessor;
import static seb39_pre_002.util.ApiDocumentUtils.getResponsePreProcessor;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class QuestionControllerDocumentationTest implements QuestionControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper questionMapper;

    @Autowired
    private Gson gson;


 //        Question questionPostDtoToQuestion(QuestionPostDto questionPostDto); //Post - requestBody //이름변경 중간 Dto 빠짐
 //        Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto); //Pacth - requestBody
 //        QuestionResponseDto questionToQuestionResponseDto(Question question); // response


    @Test
    public void postQuestionTest() throws Exception{
        //given
        QuestionDto.Post post = new QuestionDto.Post("테스트용 첫번째 제목입니다","이것은 테스트용 첫번째 내용입니다","해시태그테스트");
        String content = gson.toJson(post);
        QuestionDto.Response responseBody = new QuestionDto.Response(1L,
                "테스트용 첫번째 제목입니다",
                "이것은 테스트용 첫번째 내용입니다",
                "해시태그테스트");

        given(questionMapper.questionPostToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());

        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseBody);

        //when
        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.post("/v1/questions")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content));
        //then
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value(post.getTitle()))
                .andExpect(jsonPath("$.data.content").value(post.getContent()))
                .andExpect(jsonPath("$.data.hashtag").value(post.getHashtag()))
                .andDo(document("post-question",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("hashtag").type(JsonFieldType.STRING).description("해시태크")
                                )
                        ),
                        responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data.title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("data.hashtag").type(JsonFieldType.STRING).description("해시태그")
                                )
                        )
                ));
    }

//    @Test
//    public void patchQuestionTest() throws Exception {
//        // given
//        long questionId = 1L;
//        QuestionDto.Patch patch = (QuestionDto.Patch) StubData.MockQuestion.getRequestBody(HttpMethod.PATCH);
//        String content = toJsonContent(patch);
//
//        QuestionDto.Response responseDto = StubData.MockQuestion.getSingleResponseBody();
//
//        // willReturn()이 최소한 null은 아니어야 한다.
//        given(questionMapper.questionPatchToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
//
//        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
//
//        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(patchRequestBuilder(getURI(), questionId, content));
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
//                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
//                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
////                .andExpect(jsonPath("$.data.questionStatus").value(patch.getQuestionStatus().getStatus()))
//                .andDo(document("patch-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                getQuestionRequestPathParameterDescriptor()
//                        ),
//                        requestFields(
//                                getDefaultQuestionPatchRequestDescriptors()
//                        ),
//                        responseFields(
//                                getFullResponseDescriptors(
//                                        getDefaultQuestionResponseDescriptors(DataResponseType.SINGLE))
//                        )
//                ));
//    }

    @Test
    public void patchQuestionTest() throws Exception {
        // given
        long questionId = 1L;
        QuestionDto.Patch patch = new QuestionDto.Patch(1,"test1Title", "test1Content", "hashtag바디"); //일부만 작성 왜 안되는지 확인 필요

        String content = gson.toJson(patch);

        QuestionDto.Response responseBody = new QuestionDto.Response(1L,
                "test1Title", "test1Content", "hashtag바디");

        // willReturn()이 최소한 null은 아니어야 한다.
        given(questionMapper.questionPatchToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());

        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());

        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseBody);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .patch("/v1/questions/{question-id}", questionId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andExpect(jsonPath("$.data.hashtag").value(patch.getHashtag()))
                .andDo(document("patch-question",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                Arrays.asList(parameterWithName("question-id").description("질문 식별자 ID"))
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").optional(),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목").optional(),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용").optional(),
                                        fieldWithPath("hashtag").type(JsonFieldType.STRING).description("해시태그").optional()
                                )
                        ),
                        responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data.title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("data.hashtag").type(JsonFieldType.STRING).description("해시태그")
                                )
                        )
                ));
    }

    @Test
    public void getQuestionTest() throws Exception {
        // given
        long questionId = 1L;
        QuestionDto.Response response = new QuestionDto.Response(1L,
                "더미데이터제목",
                "더미데이터내용",
                "더미데이터해시태그");
        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/v1/questions/{question-id}", questionId)
                        .accept(MediaType.APPLICATION_JSON));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(questionId))
                .andExpect(jsonPath("$.data.title").value(response.getTitle()))
                .andDo(
                        document("get-question",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("question-id").description("질문 식별자 ID"))
                                ),
                                responseFields(
                                        Arrays.asList(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                                fieldWithPath("data.title").type(JsonFieldType.STRING).description("제목"),
                                                fieldWithPath("data.content").type(JsonFieldType.STRING).description("내용"),
                                                fieldWithPath("data.hashtag").type(JsonFieldType.STRING).description("해시태그")
                                        )
                                )
                        ));
    }


    @Test
    public void getQuestionsTest() throws Exception {
        // given
        String page = "1";
        String size = "5";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Question question1 = new Question("test1Title", "test1Content", "hashtag바디");


        Question question2 = new Question("test2Title", "test2Content", "hashtag바디2");


        Question question3 = new Question("test3Title", "test3Content", "hashtag바디3");


        Question question4 = new Question("test4Title", "test4Content", "hashtag바디4");


        Question question5 = new Question("test5Title", "test5Content", "hashtag바디5");

        Question question6 = new Question("test6Title", "test6Content", "hashtag바디6");


        Page<Question> questions = new PageImpl<>(List.of(question1, question2, question3, question4, question5, question6),
                PageRequest.of(0, 5, Sort.by("questionId").descending()), 6);
        List<QuestionDto.Response> responses = StubData.MockQuestion.getMultiResponseBody();

        // Stubbing
        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(questions);
        given(questionMapper.questionsToQuestionResponses(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/v1/questions")
                        .params(queryParams)
                        .accept(MediaType.APPLICATION_JSON));

        // then
        MvcResult result =
                actions
                        .andExpect(status().isOk())
                        .andDo(
                                document(
                                        "get-questions",
                                        preprocessRequest(prettyPrint()),
                                        preprocessResponse(prettyPrint()),
                                        requestParameters(
                                                getDefaultRequestParameterDescriptors()
                                        ),
                                        responseFields(
                                                Arrays.asList(
                                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터")
                                                                .optional(),
                                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                                        fieldWithPath("data[].title").type(JsonFieldType.STRING).description("제목"),
                                                        fieldWithPath("data[].content").type(JsonFieldType.STRING).description("내용"),
                                                        fieldWithPath("data[].hashtag").type(JsonFieldType.STRING).description("해시태그"),
                                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보")
                                                                .optional(),
                                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호")
                                                                .optional(),
                                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈")
                                                                .optional(),
                                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 건 수")
                                                                .optional(),
                                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                                                .optional()
                                                )
                                        )
                                )
                        )
                        .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
        assertThat(list.size(), is(6));
    }


//    @Test
//    public void getQuestionsTest() throws Exception {
//        // given
//        String page = "1";
//        String size = "5";
//
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
//        Page<Question> members = StubData.MockQuestion.getMultiResultQuestion();
//        List<QuestionDto.Response> responses = StubData.MockQuestion.getMultiResponseBody();
//
//        // Stubbing
//        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
//        given(questionMapper.questionsToQuestionResponses(Mockito.anyList())).willReturn(responses);
//
//        // when
//        ResultActions actions = mockMvc.perform(getRequestBuilder(getUrl(), queryParams));
//
//        // then
//        MvcResult result =
//                actions
//                        .andExpect(status().isOk())
//                        .andDo(
//                                document(
//                                        "get-questions",
//                                        getRequestPreProcessor(),
//                                        getResponsePreProcessor(),
//                                        requestParameters(
//                                                getDefaultRequestParameterDescriptors()
//                                        ),
//                                        responseFields(
//                                                getFullPageResponseDescriptors(
//                                                        getDefaultQuestionResponseDescriptors(DataResponseType.LIST))
//
//                                        )
//                                )
//                        )
//                        .andReturn();
//
//        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
//        assertThat(list.size(), is(6));
//    }


    @Test
    public void deleteQuestionTest() throws Exception {
        // given
        long questionId = 1L;
        doNothing().when(questionService).deleteQuestion(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .delete("/v1/questions/{question-id}", questionId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-question",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("question-id").description("질문 식별자 ID"))
                                )
                        )
                );
    }
}




