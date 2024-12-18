package com.study.miniProjectV2.team.service;

import com.study.miniProjectV2.team.dto.RequestCreateTeamDto;
import com.study.miniProjectV2.team.dto.TeamDto;

import java.util.List;

public interface TeamService {
    public void createTeam(String teamName);
    public List<TeamDto> getTeams();
}
