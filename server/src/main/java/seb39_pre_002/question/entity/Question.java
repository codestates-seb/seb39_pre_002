package seb39_pre_002.questions.entity;


import lombok.*;

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
@AllArgsConstructor
@Entity(name = "QUESTIONS")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionsId;      //질문 아이디

    @Column(nullable = false)
    private String questionTitle;   // 질문 제목

    private String questionContent;   // 질문 내용

    @Column(nullable = false)
    private LocalDateTime createdAt =LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt =LocalDateTime.now();

}
