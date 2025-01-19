package com.study.miniProjectV2.annualLeave.entity;

import com.study.miniProjectV2.common.exception.InsufficientAnnualLeaveException;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Table(name = "annual_leave")
@Entity
@Getter
@NoArgsConstructor
public class AnnualLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "total_days")
    private int totalDays;
    @Column(name = "used_days")
    private int usedDays;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public static AnnualLeave of(User user, Team team) {
        return AnnualLeave.builder()
                .user(user)
                .team(team)
                .totalDays(11)
                .usedDays(0)
                .build();
    }
    @Builder
    public AnnualLeave(long id, User user, Team team, int totalDays, int usedDays, LocalDateTime lastUpdate) {
        this.id = id;
        this.user = user;
        this.team = team;
        this.totalDays = totalDays;
        this.usedDays = usedDays;
        this.lastUpdate = lastUpdate;
    }

    public void useAnnualLeave() {
        this.usedDays++;
        this.lastUpdate = LocalDateTime.now();
    }
    public boolean checkAnnualDeadLine(LocalDate startDay) {

        LocalDate currentTime = LocalDate.now(); //현재날짜
        long daysUntilLeave = ChronoUnit.DAYS.between(currentTime, startDay); //현재날짜 - 연차날짜
        //날짜가 지나지 않았고, 데드라인기간 보다 많은 경우 false;
        if(daysUntilLeave >= 0 && daysUntilLeave >= team.getLeaveDeadlineDays()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkRemainingDays() {
        if(this.totalDays - this.usedDays <= 0) {
           return true;
        }
        return false;
    }

}
