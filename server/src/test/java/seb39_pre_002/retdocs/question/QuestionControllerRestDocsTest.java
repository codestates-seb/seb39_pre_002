//package seb39_pre_002.retdocs.question;
//
//
//import com.google.gson.Gson;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import seb39_pre_002.helper.ControllerTestHelper;
//import seb39_pre_002.helper.StubData;
//import seb39_pre_002.question.controller.QuestionController;
//import seb39_pre_002.question.dto.QuestionDto;
//import seb39_pre_002.question.dto.QuestionPatchDto;
//import seb39_pre_002.question.dto.QuestionPostDto;
//import seb39_pre_002.question.dto.QuestionResponseDto;
//import seb39_pre_002.question.entity.Question;
//import seb39_pre_002.question.mapper.QuestionMapper;
//import seb39_pre_002.question.service.QuestionService;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willReturn;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static seb39_pre_002.util.ApiDocumentUtils.getRequestPreProcessor;
//import static seb39_pre_002.util.ApiDocumentUtils.getResponsePreProcessor;
//
//@WebMvcTest(QuestionController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class QuestionControllerRestDocsTest implements ControllerTestHelper {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @MockBean
//    private QuestionMapper mapper;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void postQuestionTest() throws Exception {
//
//        //given
//        QuestionDto.Post post = new QuestionDto.Post("제목", "내용", "작성자Id");
//        String content = gson.toJson(post);
//
//        QuestionResponseDto responseDto =
//                new QuestionResponseDto(1L,
//                        "제목",
//                        "내용",
//                        "작성자Id"
//                );
//
//
//        given(mapper.questionPostDtoToQuestion(Mockito.any(QuestionPostDto.class))).willReturn(new Question());
//
//        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
//
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseDto);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        RestDocumentationRequestBuilders.post("/v1/questions")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//
//        //then
//        actions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.data.questionTitle").value(post.getQuestionTitle()))
//                .andExpect(jsonPath("$.data.questionContent").value(post.getQuestionContent()))
//                .andExpect(jsonPath("$.data.memberId").value(post.getMemberId()))
//                .andDo(document(
//                        "post-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("questionTitle").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("memberId").type(JsonFieldType.STRING).description("회원정보")
//
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문식별자"),
//                                        fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.STRING).description("회원정보")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void patchQuestionTest() throws Exception {
//        //given
//        long questionId = 1L;
//        QuestionDto.Patch patch = new QuestionDto.Patch(questionId, "제목1", "내용1", "작성자Id");
//        String content = gson.toJson(patch);
//
//        QuestionResponseDto responseDto =
//                new QuestionResponseDto(1L, "제목1", "내용1", "작성자Id");
//
//        given(mapper.questionPatchToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
//
//        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
//
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(responseDto);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        RestDocumentationRequestBuilders.patch("/v1/questions/{question-id}", questionId)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//        //then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
//                .andExpect(jsonPath("$.data.questionTitle").value(patch.getQuestionTitle()))
//                .andExpect(jsonPath("$.data.questionContent").value(patch.getQuestionContent()))
//                .andDo(document("patch-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
//                                        fieldWithPath("questionTitle").type(JsonFieldType.STRING).description("제목").optional(),
//                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("내용").optional(),
//                                        fieldWithPath("memberId").type(JsonFieldType.STRING).description("작성자Id").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.STRING).description("작성자Id")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void getQuestion() throws Exception {
//        //given
//        long questionId = 1L;
//        QuestionResponseDto response = new QuestionResponseDto(1L, "제목", "내용", "작성자Id");
//
//        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
//        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);
//
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders.get("/v1/questions/{question-id}", questionId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        //then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.questionId").value(questionId))
//                .andExpect(jsonPath("$.data.questionTitle").value(response.getQuestionTitle()))
//                .andExpect(jsonPath("$.data.questionContent").value(response.getQuestionContent()))
//                .andDo(
//                        document("get-question",
//                                preprocessRequest(prettyPrint()),
//                                preprocessResponse(prettyPrint()),
//                                pathParameters(
//                                        Arrays.asList(parameterWithName("question-id").description("질문 식별자"))
//                                ),
//                                responseFields(
//                                        Arrays.asList(
//                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
//                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                                fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("제목"),
//                                                fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("내용"),
//                                                fieldWithPath("data.memberId").type(JsonFieldType.STRING).description("작성자Id")
//                                        )
//                                )
//                        ));
//    }
//
//
//    @Test
//    public void getQuestionsTest() throws Exception {
//        //given
//        String page = "1";
//        String size = "10";
//
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
//        Question question1 = new Question("제목","내용","작성자ID");
//
//        Question question2 = new Question("제목1","내용1","작성자ID1");
//
//        Page<Question> questions = new PageImpl<>(List.of(question1,question2),
//                PageRequest.of(0,10, Sort.by("questionId").descending()),2);
//
//        List<QuestionDto.Response> responses = StubData.MockQuestion.getMultiResponseBody();
//
//        //Stubbing
//        given(questionService.findQuestions(Mockito.anyInt(),Mockito.anyInt())).willReturn(questions);
//        given(mapper.questionToQuestionResponseDto(Mockito.anyList())).willReturn(responses);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders.get("/v1/questions")
//                        .params(queryParams)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        //then
//        MvcResult result =
//                actions
//                        .andExpect(status().isOk())
//                        .andDo(
//                                document(
//                                        "get-questions",
//                                        preprocessRequest(prettyPrint()),
//                                        preprocessResponse(prettyPrint()),
//                                        requestParameters(
//                                                getDefaultRequestParameterDescriptors()
//                                        ),
//                                        responseFields(
//                                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터").optional(),
//                                                fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                                fieldWithPath("data[].questionTitle").type(JsonFieldType.STRING).description("제목"),
//                                                fieldWithPath("data[].questionContent").type(JsonFieldType.STRING).description("내용"),
//                                                fieldWithPath("data[].memberId").type(JsonFieldType.STRING).description("작성자Id"),
//                                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보")
//                                                        .optional(),
//                                                fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호")
//                                                        .optional(),
//                                                fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈")
//                                                        .optional(),
//                                                fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 건 수")
//                                                        .optional(),
//                                                fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
//                                                        .optional()
//                                        )
//                                )
//                        )
//                        .andReturn();
//
//        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
//        assertThat(list.size(), is(2));
//    }
//
//    @Test
//    public void deleteQuestionTest() throws Exception {
//        //given
//        long questionId = 1L;
//        doNothing().when(questionService).deleteQuestion(Mockito.anyLong());
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                RestDocumentationRequestBuilders.delete("/v1/questions/{question-id}",questionId));
//
//        //then
//        actions.andExpect(status().isNoContent())
//                .andDo(
//                        document(
//                                "delete-question",
//                                preprocessRequest(prettyPrint()),
//                                preprocessResponse(prettyPrint()),
//                                pathParameters(
//                                        Arrays.asList(parameterWithName("question-id").description("질문 식별자 id"))
//                                )
//                        )
//                );
//    }
//}
//
