package com.study.miniProjectV2.attendance.dto;

import com.study.miniProjectV2.attendance.entity.Attendance;
import com.study.miniProjectV2.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RequestCheckInOutDto {
    private Long userId;
    private LocalDateTime nowTime;

    public Attendance toEntityForCheckIn(User user) {
        return Attendance.builder()
                .user(user)
                .checkInTime(this.nowTime)
                .build();
    }

}
