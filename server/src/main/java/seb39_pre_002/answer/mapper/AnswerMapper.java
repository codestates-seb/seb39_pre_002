package seb39_pre_002.answer.mapper;

import org.mapstruct.Mapper;
import seb39_pre_002.answer.dto.AnswerDto;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.question.dto.QuestionDto;
import seb39_pre_002.question.dto.QuestionPostDto;
import seb39_pre_002.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    //답변 등록
    Answer answerPostDtoToAnswer(AnswerDto requestBody);

    //조회
    List<AnswerDto> answerToAnswerResponseDto(List<Answer> answers);

    //답변 수정
    Answer answerPatchToAnswer(AnswerDto requestBody);

    AnswerDto answerToAnswerDtoResponse(Answer answer);
}
