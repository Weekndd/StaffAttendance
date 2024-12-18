package com.study.miniProjectV2.user.dto;

import com.study.miniProjectV2.user.entity.User;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {
    private String name;
    private String teamName;
    private String role;
    private Date birthday;
    private Date workStartDate;

    @Builder
    public UserDto(String name, String teamName, String role, Date birthday, Date workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }
    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .name(user.getName())
                .teamName(user.getTeam().getName())
                .role(user.getRole().getRoleType())
                .birthday(user.getBirthday())
                .workStartDate(user.getWorkStartDate())
                .build();
    }
}
