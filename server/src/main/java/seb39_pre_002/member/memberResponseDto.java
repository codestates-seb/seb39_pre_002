package seb39_pre_002.member;

import seb39_pre_002.member.member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class memberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;

}
