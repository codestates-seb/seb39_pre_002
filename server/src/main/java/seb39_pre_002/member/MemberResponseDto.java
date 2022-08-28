package seb39_pre_002.member;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class MemberResponseDto {
    private long memberId;
    private String email;
    private String memberName;
    private String memberPassword;

    private Member.MemberStatus memberStatus;

    public String getMemberStatus() {
        return memberStatus.getStatus();
    }
}
