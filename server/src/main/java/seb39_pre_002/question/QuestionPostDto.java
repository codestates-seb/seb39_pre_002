package seb39_pre_002.question;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuestionPostDto {

    private String title;
    private String content;
    private String hashtag; //해시태크 나중에 하기
    private LocalDateTime createdAt; //질문시간기록
    private String memberName; // 질문자 맴버랑 연결 필요 - 하나의 맴버가 여러개의 질문을 할 수 있음

    //해시태그, 등록시간, 수정시간, 삭제시간 추가 예정
}
