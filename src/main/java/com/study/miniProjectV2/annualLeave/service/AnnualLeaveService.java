package com.study.miniProjectV2.annualLeave.service;

import com.study.miniProjectV2.annualLeave.dto.RequestSubmitAnnualLeaveDto;
import com.study.miniProjectV2.annualLeave.entity.AnnualLeave;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;

public interface AnnualLeaveService {
    void createAnnualLeave(User newUser, Team team);
    void submitAnnualLeave(RequestSubmitAnnualLeaveDto dto);
    AnnualLeave getAnnualLeaveByUserId(long userId);
}
