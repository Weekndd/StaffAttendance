package com.study.miniProjectV2.user.service;

import com.study.miniProjectV2.annualLeave.service.AnnualLeaveService;
import com.study.miniProjectV2.team.dto.TeamDto;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.team.repository.TeamRepository;
import com.study.miniProjectV2.team.service.TeamService;
import com.study.miniProjectV2.user.dto.RequestCreateUserDto;
import com.study.miniProjectV2.user.dto.UserDto;
import com.study.miniProjectV2.user.entity.User;
import com.study.miniProjectV2.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final TeamService teamService;
    private final AnnualLeaveService annualLeaveService;

    @Override
    @Transactional
    public void createUser(RequestCreateUserDto requestCreateUserDto) {
        Team team = teamService.getTeamById(requestCreateUserDto.getTeam_id())
                .toEntity();
        User newUser = requestCreateUserDto.toEntity(team);
        newUser = userRepository.save(newUser);
        annualLeaveService.createAnnualLeave(newUser, team); //연차 테이블에도 신규유저 등록
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> users = userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .toList();
        return users;
    }
}
