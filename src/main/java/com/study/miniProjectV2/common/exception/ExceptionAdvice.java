package com.study.miniProjectV2.common.exception;

import com.study.miniProjectV2.common.response.BaseResponse;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    //스웨거에 보여줄 Response
    @ApiResponse(responseCode = "404", description = "데이터를 찾을 수 없습니다.", content = @Content)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<BaseResponseStatus> notFoundExceptionHandler(NotFoundException exception) {
        log.warn("NotFoundException has occurred. %s %s %s".formatted(
                exception.getMessage(),
                exception.getCause(),
                exception.getStackTrace()));
        return new BaseResponse<>(exception.getStatus());
    }

    @ExceptionHandler
    @ApiResponse(responseCode = "404", description = "중복되는 데이터 입니다.", content = @Content)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<BaseResponseStatus> duplicateExceptionHandler(DuplicateException exception) {
        log.warn("DuplicateException has occurred. %s"
                .formatted(exception.getStatus().getMessage()));
        return new BaseResponse<>(exception.getStatus());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public BaseResponse<BaseResponseStatus> InsufficientAnnualLeaveException(InsufficientAnnualLeaveException exception) {
        log.warn("InsufficientAnnualLeaveException has occurred. s%"
                .formatted(exception.getStatus().getMessage()));
        return new BaseResponse<>(exception.getStatus());
    }


}
