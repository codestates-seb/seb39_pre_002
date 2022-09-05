package seb39_pre_002.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seb39_pre_002.member.entity.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {

    @Getter
    @AllArgsConstructor // 테스트를 위해 추가
    public static class Post {

        private String memberEmail;

        private String memberName;

        private String memberPassword;
    }


    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long memberId;

        private String memberName;

        private String memberPassword;

        private Member.MemberStatus memberStatus;

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }
    }


    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String memberEmail;
        private String memberName;
        private String memberPassword;
        private Member.MemberStatus memberStatus;

        public String getMemberStatus() {
            return memberStatus.getStatus();
        }
    }
}
