package com.study.miniProjectV2.user.dto;


import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class RequestCreateUserDto {
    private String name;
    private long team_id;
    private Date birthday;

    @Builder
    public RequestCreateUserDto(String name, long team_id, Date birthday) {
        this.name = name;
        this.team_id = team_id;
        this.birthday = birthday;
    }
    public User toEntity(Team team) {
        return User.builder()
                .name(this.name)
                .birthday(this.birthday)
                .team(team)
                .build();
    }
}
