package seb39_pre_002.question.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.member.entity.Member;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    @Column(name = "QUESTION_ID")
    private long questionId;      //질문 아이디

    @Column(nullable = false)
    private String questionTitle;   // 질문 제목

    private String questionContent;   // 질문 내용

    private String questionHashtag; //해시태그

    private String username; // 회원 아이디

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

//    @ManyToOne   // (1)
//    @JoinColumn(name = "MEMBER_ID")  // (2)
//    private Member member;
//
//    public void addMember(Member member) {
//        this.member = member;
//    }


    public Question(String questionTitle, String questionContent, String username) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.username = username;
    }
}
