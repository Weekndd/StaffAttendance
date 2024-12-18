package com.study.miniProjectV2.user.entity;

import com.study.miniProjectV2.attendance.entity.Attendance;
import com.study.miniProjectV2.team.entity.Team;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    private Date birthday;

    @CreationTimestamp
    @Column(name = "work_start_date", nullable = false, updatable = false)
    private Date workStartDate;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Attendance> attendanceList;

    @Builder
    public User(String name, Date birthday, Team team) {
        this.name = name;
        this.birthday = birthday;
        this.team = team;
    }
}
