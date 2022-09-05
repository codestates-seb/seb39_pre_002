package seb39_pre_002.member.dto;

import lombok.Getter;

@Getter
public class MemberPatchDto {
    private long id;

    private String username;
    private String password;

    private String roles;

    private String provider;
    private String providerId;

//        private Member.MemberStatus memberStatus;

    public void setId(long id) {
        this.id = id;
    }
}
