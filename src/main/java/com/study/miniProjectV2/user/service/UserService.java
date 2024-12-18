package com.study.miniProjectV2.user.service;

import com.study.miniProjectV2.user.dto.RequestCreateUserDto;
import com.study.miniProjectV2.user.dto.UserDto;

import java.util.List;

public interface UserService {
    public void createUser(RequestCreateUserDto requestCreateUserDto);
    public List<UserDto> getUsers();
}
