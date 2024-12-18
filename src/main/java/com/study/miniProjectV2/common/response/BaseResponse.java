package com.study.miniProjectV2.common.response;

import lombok.Getter;

@Getter
public class BaseResponse<T> {
    private final boolean isSeccess;
    private final String message;
    private final int code;
    private T result;

    public BaseResponse(T result) {
        this.isSeccess = BaseResponseStatus.SUCCESS.isSuccess();
        this.message = BaseResponseStatus.SUCCESS.getMessage();
        this.code = BaseResponseStatus.SUCCESS.getCode();
        this.result = result;
    }

    public BaseResponse(BaseResponseStatus status, String message) {
        this.isSeccess = status.isSuccess();
        this.code = status.getCode();
        this.message = message;
    }

    public BaseResponse(BaseResponseStatus status) {
        this.isSeccess = status.isSuccess();
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseResponse(boolean isSeccess, int code, String message, T result) {
        this.isSeccess = isSeccess;
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
