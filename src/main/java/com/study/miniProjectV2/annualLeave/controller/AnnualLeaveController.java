package com.study.miniProjectV2.annualLeave.controller;

import com.study.miniProjectV2.annualLeave.dto.RequestSubmitAnnualLeaveDto;
import com.study.miniProjectV2.annualLeave.service.AnnualLeaveService;
import com.study.miniProjectV2.common.response.BaseResponse;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/annualLeave")
@Tag(name = "4. AnnualLeave")
@RequiredArgsConstructor
public class AnnualLeaveController {
    private final AnnualLeaveService annualLeaveService;

    @PostMapping("/useAnnualLeave")
    public BaseResponse<BaseResponseStatus> useAnnualLeave(@RequestBody RequestSubmitAnnualLeaveDto requestSubmitAnnualLeaveDto) {
        annualLeaveService.submitAnnualLeave(requestSubmitAnnualLeaveDto);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
