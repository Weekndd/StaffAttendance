package com.study.miniProjectV2.attendance.service;

import com.study.miniProjectV2.attendance.dto.RequestCheckInOutDto;
import com.study.miniProjectV2.attendance.entity.Attendance;
import com.study.miniProjectV2.attendance.repository.AttendanceRepository;
import com.study.miniProjectV2.common.exception.DuplicateException;
import com.study.miniProjectV2.common.exception.NotFoundException;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import com.study.miniProjectV2.user.entity.User;
import com.study.miniProjectV2.user.repository.UserRepository;
import com.study.miniProjectV2.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService{
    private final AttendanceRepository attendanceRepository;
    private final UserService userService;

    @Transactional
    @Override
    public void checkIn(RequestCheckInOutDto requestCheckInOutDto) {
        User user = userService.getUserById(requestCheckInOutDto.getUserId());

        LocalDateTime checkInTime = requestCheckInOutDto.getNowTime();
        if(validateCheckInDuplication(checkInTime)) {
            attendanceRepository.save(requestCheckInOutDto
                    .toEntityForCheckIn(user));
        }
        else {
            throw new DuplicateException(BaseResponseStatus.DUPLICATE_CHECK_IN_DATE);
        }
    }
    private boolean validateCheckInDuplication(LocalDateTime checkInTime) {
        String date =  checkInTime.toLocalDate()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Optional<Attendance> attendance = attendanceRepository.findByCheckInDate(date);
        if(attendance.isEmpty()) return true; //당일 출근 정보가 없음
        else return false; //이미 당일 출근 정보가 있음
    }

    @Transactional
    @Override
    public void checkOut(RequestCheckInOutDto requestCheckInOutDto) {
        User user = userService.getUserById(requestCheckInOutDto.getUserId());
        Attendance latestAttendance = attendanceRepository.findLatestAttendance()
                .orElseThrow(() -> new NotFoundException(BaseResponseStatus.CHECK_IN_TIME_NOT_FOUND));

        if(latestAttendance.isCheckInToday()) { //출근 기록이 있다면
            latestAttendance.doCheckOut(requestCheckInOutDto.getNowTime());
        }
        else {
            throw new NotFoundException(BaseResponseStatus.CHECK_IN_TIME_NOT_FOUND);
        }
    }

    @Override
    public void submitAnnualLeave(User user, LocalDate startDay) {
        attendanceRepository.save(Attendance.builder()
                .user(user)
                .checkInTime(startDay.atTime(00,00))
                .checkOutTime(startDay.atTime(23,59))
                .usingDayOff(true)
                .build()
        );
    }
}
