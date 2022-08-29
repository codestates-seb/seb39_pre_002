package seb39_pre_002.questions.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import seb39_pre_002.questions.dto.QuestionsPatchDto;
import seb39_pre_002.questions.dto.QuestionsPostDto;
import seb39_pre_002.questions.dto.QuestionsResponseDto;
import seb39_pre_002.questions.entity.Questions;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-28T18:37:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class QuestionsMapperImpl implements QuestionsMapper {

    @Override
    public Questions questionsPostDtoToQuestions(QuestionsPostDto questionsPostDto) {
        if ( questionsPostDto == null ) {
            return null;
        }

        Questions questions = new Questions();

        questions.setQuestionTitle( questionsPostDto.getQuestionTitle() );
        questions.setQuestionContent( questionsPostDto.getQuestionContent() );

        return questions;
    }

    @Override
    public List<QuestionsResponseDto> questionsToQuestionsResponseDto(List<Questions> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionsResponseDto> list = new ArrayList<QuestionsResponseDto>( questions.size() );
        for ( Questions questions1 : questions ) {
            list.add( questionsToQuestionsResponse( questions1 ) );
        }

        return list;
    }

    @Override
    public Questions questionsPatchToQuestions(QuestionsPatchDto questionsPatchDto) {
        if ( questionsPatchDto == null ) {
            return null;
        }

        Questions questions = new Questions();

        if ( questionsPatchDto.getQuestionsId() != null ) {
            questions.setQuestionsId( questionsPatchDto.getQuestionsId() );
        }
        questions.setQuestionTitle( questionsPatchDto.getQuestionTitle() );
        questions.setQuestionContent( questionsPatchDto.getQuestionContent() );

        return questions;
    }

    @Override
    public QuestionsResponseDto questionsToQuestionsResponse(Questions questions) {
        if ( questions == null ) {
            return null;
        }

        Long questionsId = null;
        String questionTitle = null;
        String questionContent = null;

        questionsId = questions.getQuestionsId();
        questionTitle = questions.getQuestionTitle();
        questionContent = questions.getQuestionContent();

        QuestionsResponseDto questionsResponseDto = new QuestionsResponseDto( questionsId, questionTitle, questionContent );

        return questionsResponseDto;
    }
}
