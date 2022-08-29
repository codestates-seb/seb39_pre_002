package seb39_pre_002.exception;

import lombok.Getter;

public enum ExceptionCode {

    QUESTIONS_NOT_FOUND(404, "Member not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
