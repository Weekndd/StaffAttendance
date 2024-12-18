package com.study.miniProjectV2.common.exception;

import com.study.miniProjectV2.common.response.BaseResponseStatus;

public class NotFoundException extends BaseException{
    public NotFoundException(BaseResponseStatus status) {
        super(status);
    }
}
