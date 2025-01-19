package com.study.miniProjectV2.team.service;

import com.study.miniProjectV2.common.exception.NotFoundException;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
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
    public void createTeam(RequestCreateTeamDto requestCreateTeamDto) {
        teamRepository.save(requestCreateTeamDto.toEntity());
    }

    @Override
    public List<TeamDto> getTeams() {
        List<TeamDto> teams = teamRepository.findAll()
                .stream()
                .map(TeamDto::fromEntity)
                .toList();
        return teams;
    }

    @Override
    public TeamDto getTeamById(long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(BaseResponseStatus.TEAM_NOT_FOUND));
        return TeamDto.fromEntity(team);
    }
}
