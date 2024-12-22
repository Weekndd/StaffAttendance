package com.study.miniProjectV2.team.entity;

import com.study.miniProjectV2.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "leave_deadline_days")
    private long leaveDeadlineDays;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "team")
    private List<User> teamUsers;



    @Builder
    public Team(long id, String name, long leaveDeadlineDays) {
        this.id = id;
        this.leaveDeadlineDays = leaveDeadlineDays;
        this.name = name;
    }
}

