package seb39_pre_002.question.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


/*********************************
 *
 *  질문 Entity
 *  추 후 추가 될면 수정
 *
 * ******************************/


@Data
@NoArgsConstructor
@Entity(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;      //질문 아이디

    @Column(nullable = false)
    private String questionTitle;   // 질문 제목

    private String questionContent;   // 질문 내용

    private String memberId; // 회원 아이디

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;


    public Question(String questionTitle, String questionContent, String memberId) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.memberId = memberId;
    }
}
