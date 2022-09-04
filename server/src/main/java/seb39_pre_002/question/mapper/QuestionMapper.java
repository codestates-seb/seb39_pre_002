package seb39_pre_002.question.mapper;

import org.mapstruct.Mapper;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.dto.QuestionPatchDto;
import seb39_pre_002.question.dto.QuestionPostDto;
import seb39_pre_002.question.dto.QuestionResponseDto;
import seb39_pre_002.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    //질문 등록
    Question questionPostDtoToQuestion(QuestionPostDto requestBody);

    //질문 조회
    List<QuestionDto.Response> questionToQuestionResponseDto(List<Question> question);

    //질문 수정
    Question questionPatchToQuestion(QuestionDto.Patch requestBody);

    QuestionResponseDto questionToQuestionResponse(Question question);
}
