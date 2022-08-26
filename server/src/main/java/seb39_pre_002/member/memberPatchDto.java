package seb39_pre_002.member;

import lombok.Getter;

@Getter
public class memberPatchDto {
    private long memberId;

    private String memberName;

    private String email;
    private String memberPassword;

//    public String getmemberName() {
//        return memberName;
//    }
//
//    public String getmemberPassword() {
//        return memberPassword;
//    }
//
//    public long getMemberId() {
//        return memberId;
//    }

    public void setmemberId(long memberId) {
        this.memberId = memberId;
    }
}