package seb39_pre_002.question;

import org.mapstruct.Mapper;
import seb39_pre_002.member.Member;
import seb39_pre_002.member.MemberResponseDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);
    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);
    QuestionResponseDto questionToQuestionResponseDto(Question question);
    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);
}

