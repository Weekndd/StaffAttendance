package com.study.miniProjectV2.common.exception;

import com.study.miniProjectV2.common.response.BaseResponseStatus;

public class InsufficientAnnualLeaveException extends BaseException{

    public InsufficientAnnualLeaveException(BaseResponseStatus status) {
        super(status);
    }
}
