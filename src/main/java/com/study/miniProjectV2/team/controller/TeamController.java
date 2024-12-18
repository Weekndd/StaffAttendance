package com.study.miniProjectV2.team.controller;

import com.study.miniProjectV2.common.response.BaseResponse;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import com.study.miniProjectV2.team.dto.RequestCreateTeamDto;
import com.study.miniProjectV2.team.dto.TeamDto;
import com.study.miniProjectV2.team.service.TeamService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/team")
@Tag(name = "2 team")
public class TeamController {
    private final TeamService teamService;
    @PostMapping
    public BaseResponse<String> createTeam(@RequestBody RequestCreateTeamDto requestCreateTeamDto) {
        teamService.createTeam(requestCreateTeamDto.getName());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @GetMapping
    public BaseResponse<List<TeamDto>> getTeams() {
        List<TeamDto> result = teamService.getTeams();
        return new BaseResponse<>(result);
    }

}
