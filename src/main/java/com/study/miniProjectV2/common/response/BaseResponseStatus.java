package com.study.miniProjectV2.common.response;

import org.springframework.http.HttpStatus;

public enum BaseResponseStatus {
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공했습니다."),
    //유저 에러
    USER_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "유저를 찾을 수 없습니다."),

    //팀 에러
    TEAM_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "팀 정보를 찾을 수 없습니다."),

    //춭퇴근 에러
    CHECK_IN_TIME_NOT_FOUND(false, HttpStatus.NOT_FOUND.value(), "출근 정보를 찾을 수 없습니다."),
    DUPLICATE_CHECK_IN_DATE(false, HttpStatus.CONFLICT.value(), "이미 출근처리가 되었습니다."),

    //연차 에러
    NOT_FOUND_ANNUAL_LEAVE(false, HttpStatus.NOT_FOUND.value(), "연차 정보를 찾을 수 없습니다."),
    INSUFFICIENT_ANNUAL_LEAVE(false, HttpStatus.UNPROCESSABLE_ENTITY.value(), "사용 가능한 연차 일수를 초과했습니다."),
    EXCEED_ANNUAL_LEAVE_DEADLINE(false, HttpStatus.BAD_REQUEST.value(), "연차 신청 마감 날짜가 지났습니다.")
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
