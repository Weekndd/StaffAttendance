package com.study.miniProjectV2.common.exception;

import com.study.miniProjectV2.common.response.BaseResponseStatus;

public class DuplicateException extends BaseException{
    public DuplicateException(BaseResponseStatus status) {
        super(status);
    }
}
