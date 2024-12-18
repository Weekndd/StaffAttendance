package com.study.miniProjectV2.attendance.service;


import com.study.miniProjectV2.attendance.dto.RequestCheckInOutDto;

public interface AttendanceService {
    public void checkIn(RequestCheckInOutDto requestCheckInDto);
    public void checkOut(RequestCheckInOutDto requestCheckInDto);
}
