package com.study.miniProjectV2.team.dto;

import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamDto {
    private long id;
    private String name;
    private String manager;
    private long userCount;

    @Builder
    public TeamDto(long id, String name, String manager, long userCount) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.userCount = userCount;
    }

    public static TeamDto fromEntity(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .manager(team.getManager().getName())
                .userCount(team.getTeamUsers().size())
                .build();
    }
}