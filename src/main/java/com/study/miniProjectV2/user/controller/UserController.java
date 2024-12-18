package com.study.miniProjectV2.user.controller;

import com.study.miniProjectV2.common.response.BaseResponse;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import com.study.miniProjectV2.user.dto.RequestCreateUserDto;
import com.study.miniProjectV2.user.dto.UserDto;
import com.study.miniProjectV2.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "1 User")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public BaseResponse<String> createUser(@RequestBody RequestCreateUserDto requestCreateUserDto) {
        userService.createUser(requestCreateUserDto);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @GetMapping
    public BaseResponse<List<UserDto>> getUsers() {
        List<UserDto> result = userService.getUsers();
        return new BaseResponse<>(result);
    }
}
