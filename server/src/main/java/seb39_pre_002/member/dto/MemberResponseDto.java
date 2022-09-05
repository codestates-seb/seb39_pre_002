package seb39_pre_002.member.dto;

import lombok.Builder;
import lombok.Getter;
import seb39_pre_002.member.entity.Member;

@Builder
@Getter

public class MemberResponseDto {
    private long memberId;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

    private Member.MemberStatus memberStatus;

    public String getMemberStatus() {
        return memberStatus.getStatus();
    }
}
