package seb39_pre_002.member;

import lombok.Getter;

@Getter
public class MemberPatchDto {
    private long memberId;
    private String memberName;
    private String email;
    private String memberPassword;

    private Member.MemberStatus memberStatus;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}