package seb39_pre_002.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class member {
    private long memberId;

    private String email;

    private String memberName;

    private String memberPassword; // 나중에 지우기

}
