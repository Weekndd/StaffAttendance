package com.study.miniProjectV2.common.response;

import org.springframework.http.HttpStatus;

public enum BaseResponseStatus {
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공했습니다."),
    USER_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "유저를 찾을 수 없습니다."),
    CHECK_IN_TIME_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "출근 정보를 찾을 수 없습니다."),
    DUPLICATE_CHECK_IN_DATE(false, HttpStatus.CONFLICT.value(), "이미 출근처리가 되었습니다.")
    ;

    private boolean isSuccess;
    private int code;
    private String message;


    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
