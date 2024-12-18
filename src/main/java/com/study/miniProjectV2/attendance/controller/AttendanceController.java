package com.study.miniProjectV2.attendance.controller;

import com.study.miniProjectV2.attendance.dto.RequestCheckInOutDto;
import com.study.miniProjectV2.attendance.service.AttendanceService;
import com.study.miniProjectV2.common.response.BaseResponse;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@Tag(name = "3 Attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/checkIn")
    public BaseResponse<String> checkIn(@RequestBody RequestCheckInOutDto requestCheckInOutDto) {
        System.out.println(requestCheckInOutDto.getNowTime());
        attendanceService.checkIn(requestCheckInOutDto);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @PostMapping("/checkOut")
    public BaseResponse<String> checkOut(@RequestBody RequestCheckInOutDto requestCheckInOutDto) {
        attendanceService.checkOut(requestCheckInOutDto);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
