package com.study.miniProjectV2.team.dto;

import com.study.miniProjectV2.team.entity.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamDto {
    private long id;
    private String name;
    private String manager;
    private long userCount;
    private long leaveDaedlineDays;

    @Builder
    public TeamDto(long id, String name, String manager, long userCount, long leaveDaedlineDays) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.userCount = userCount;
        this.leaveDaedlineDays = leaveDaedlineDays;
    }

    public static TeamDto fromEntity(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .manager(team.getManager().getName())
                .userCount(team.getTeamUsers().size())
                .leaveDaedlineDays(team.getLeaveDeadlineDays())
                .build();
    }

    public Team toEntity() {
        return Team.builder()
                .id(this.id)
                .name(this.name)
                .leaveDeadlineDays(this.leaveDaedlineDays)
                .build();
    }

}
