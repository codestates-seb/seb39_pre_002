package seb39_pre_002.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.dto.QuestionPatchDto;
import seb39_pre_002.question.dto.QuestionPostDto;
import seb39_pre_002.question.dto.QuestionResponseDto;
import seb39_pre_002.question.entity.Question;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    Question questionPostToQuestion(QuestionDto.Post requestBody); //Post - requestBody
    Question questionPatchToQuestion(QuestionDto.Patch requestBody); //Pacth - requestBody
    QuestionDto.Response questionToQuestionResponse(Question question); // response
    List<QuestionDto.Response> questionsToQuestionResponses(List<Question> questions); //전체목록 조회 s붙음
}

