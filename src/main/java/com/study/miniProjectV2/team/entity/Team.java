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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "team")
    List<User> teamUsers;

    @Builder
    public Team(String name) {
        this.name = name;
    }
}
