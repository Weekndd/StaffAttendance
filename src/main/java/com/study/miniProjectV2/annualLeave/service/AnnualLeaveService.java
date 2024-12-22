package com.study.miniProjectV2.annualLeave.service;

import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;

public interface AnnualLeaveService {
    public void createAnnualLeave(User newUser, Team team);
}
