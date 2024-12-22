package com.study.miniProjectV2.annualLeave.entity;

import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

}
