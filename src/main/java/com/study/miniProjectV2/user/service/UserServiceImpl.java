package com.study.miniProjectV2.user.service;

import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.team.repository.TeamRepository;
import com.study.miniProjectV2.user.dto.RequestCreateUserDto;
import com.study.miniProjectV2.user.dto.UserDto;
import com.study.miniProjectV2.user.entity.User;
import com.study.miniProjectV2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    @Override
    public void createUser(RequestCreateUserDto requestCreateUserDto) {
        Team team = teamRepository.findById(requestCreateUserDto.getTeam_id())
                .orElseThrow(IllegalArgumentException::new);
        User newUser = requestCreateUserDto.toEntity(team);
        userRepository.save(newUser);
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
