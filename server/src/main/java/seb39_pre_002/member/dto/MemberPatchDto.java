package seb39_pre_002.member.dto;

import lombok.Getter;
import seb39_pre_002.member.entity.Member;

@Getter
public class MemberPatchDto {
    private long memberId;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

    private Member.MemberStatus memberStatus;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}