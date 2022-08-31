package seb39_pre_002.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

//@AllArgsConstructor //파라미터 갖는 생성자 자동생성
@NoArgsConstructor //없는거 기본 생성자 자동 생성
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    @Column(nullable = false)
//  private String questionTitle;
    private String questionTitle;
    @Column(nullable = false)
    private String questionContent;
//    private String questionContent;

    @Column
    private String questionHashtag; //해시태크 나중에 하기

    @Column
    private LocalDateTime createdAt; //질문시간기록 입력값 모르겠음

//    @Column(nullable = false)
////            ,updatable = false, unique = true)
//    private String memberName; // 질문자

//    @Enumerated(value = EnumType.STRING)
//    @Column(length = 20, nullable = false)
//    private QuestionStatus  questionStatus = QuestionStatus.Question_Create;
//
    public Question(String questionTitle, String questionContent, String questionHashtag) {

        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionHashtag = questionHashtag;
    }

//    public enum  QuestionStatus {
//        Question_Create("작성중"),
//        Question_modify("수정"),
//        Question_Delete("삭제"),
//        Question_completion("완료");
//
//        @Getter
//        private String status;
//
//        QuestionStatus(String status) {
//            this.status = status;
//        }
//    }
}



