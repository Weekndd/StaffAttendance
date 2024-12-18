package com.study.miniProjectV2.team.service;

import com.study.miniProjectV2.team.dto.RequestCreateTeamDto;
import com.study.miniProjectV2.team.dto.TeamDto;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;
    @Override
    public void createTeam(String teamName) {
        teamRepository.save(Team.builder()
                .name(teamName)
                .build());
    }

    @Override
    public List<TeamDto> getTeams() {
        List<TeamDto> teams = teamRepository.findAll()
                .stream()
                .map(TeamDto::fromEntity)
                .toList();
        return teams;
    }
}
