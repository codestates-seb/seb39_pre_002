package seb39_pre_002.member.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seb39_pre_002.question.entity.Question;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//클래스 정리 필요 너무 중구난방으로 했음 단어?마다 첫글자 대문자로 하기
//매핑 아직 안함

//@AllArgsConstructor //파라미터 갖는 생성자 자동생성
@Data
@NoArgsConstructor //없는거 기본 생성자 자동 생성
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String memberEmail;
    @Column(length = 16, nullable = false, unique = true)
    private String memberName;
    @Column(length = 16, nullable = false)
    private String memberPassword; // 나중에 지우기

    private String roles;

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }


    //추가
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false) //회원 상태 저장
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

//    @Column(nullable = false)  //생성시간
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @Column(nullable = false, name = "LAST_MODIFIED_AT") //수정시간
//    private LocalDateTime modifiedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    public Member(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public Member(String memberEmail, String memberName, String memberPassword) {
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
    }

    public void setQuestion(Question question){
        questions.add(question);
        if(question.getMember() != this){
            question.setMember(this);
        }
    }


    public enum MemberStatus { //회원 상태 이넘
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
