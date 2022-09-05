package seb39_pre_002.member.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seb39_pre_002.answer.entity.Answer;
import seb39_pre_002.question.entity.Question;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
//@Getter
public class Member {

    @Builder
    public Member(String username, String email, String role, String provider, String providerId){
        this.username = username;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDateTime createdAt = LocalDateTime.now();

    private String provider;
    private String providerId;


    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();}
