package com.study.miniProjectV2.attendance.entity;

import com.study.miniProjectV2.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "using_day_off")
    private boolean usingDayOff;

    @Builder
    public Attendance(User user, LocalDateTime checkInTime, LocalDateTime checkOutTime, boolean usingDayOff) {
        this.user = user;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.usingDayOff = usingDayOff;
    }

    public boolean isCheckInToday() {
        if(this.checkOutTime==null) return true; //chekOutTime이 null이면 아직 퇴근 전
        else return false; //checkOutTime이 이미 있다면 오늘 출근을 안한 것(가장 최근 것 조회라)
    }
    public void doCheckOut(LocalDateTime nowTime) {
        this.checkOutTime = nowTime;
    }
}
