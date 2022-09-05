package seb39_pre_002.member.dto;

import lombok.Getter;

@Getter
public class MemberPostDto {
    private String email;
    private String username;
    private String password;
    private String provider;
    private String providerId;
    private String roles;
}
