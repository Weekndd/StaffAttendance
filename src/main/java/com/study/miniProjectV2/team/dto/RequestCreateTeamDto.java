package com.study.miniProjectV2.team.dto;

import com.study.miniProjectV2.team.entity.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class RequestCreateTeamDto {
    private String name;
    private long leaveDeadlineDays;

    public Team toEntity() {
        return Team.builder()
                .name(this.getName())
                .leaveDeadlineDays(this.getLeaveDeadlineDays())
                .build();
    }
}
