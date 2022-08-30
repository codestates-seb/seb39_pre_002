package seb39_pre_002.questions.mapper;

import org.mapstruct.Mapper;
import seb39_pre_002.questions.dto.QuestionsPatchDto;
import seb39_pre_002.questions.dto.QuestionsPostDto;
import seb39_pre_002.questions.dto.QuestionsResponseDto;
import seb39_pre_002.questions.entity.Questions;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionsMapper {

    //질문 등록
    Questions questionsPostDtoToQuestions(QuestionsPostDto questionsPostDto);

    //질문 조회
    List<QuestionsResponseDto> questionsToQuestionsResponseDto(List<Questions> questions);

    //질문 수정
    Questions questionsPatchToQuestions(QuestionsPatchDto questionsPatchDto);

    QuestionsResponseDto questionsToQuestionsResponse(Questions questions);
}
