package seb39_pre_002.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {

    @Getter
    @AllArgsConstructor // 테스트를 위해 추가
    public static class Post {

        private String email;
        private String username;
        private String password;
        private String provider;
        private String providerId;
        private String roles;
    }


    @Getter
    @AllArgsConstructor
    public static class Patch {
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


    @AllArgsConstructor
    @Getter
    public static class Response {
        private long id;
        private String email;
        private String username;
        private String password;
        private String roles;

        private String provider;
        private String providerId;
//        private Member.MemberStatus memberStatus;
//
//        public String getMemberStatus() {
//            return memberStatus.getStatus();
//        }
    }
}

