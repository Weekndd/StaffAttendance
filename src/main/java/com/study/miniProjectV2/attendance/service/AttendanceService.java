package com.study.miniProjectV2.attendance.service;


import com.study.miniProjectV2.attendance.dto.RequestCheckInOutDto;
import com.study.miniProjectV2.user.entity.User;

import java.time.LocalDate;

public interface AttendanceService {
    void checkIn(RequestCheckInOutDto requestCheckInDto);
    void checkOut(RequestCheckInOutDto requestCheckInDto);
    void submitAnnualLeave(User user, LocalDate startDay);
}
