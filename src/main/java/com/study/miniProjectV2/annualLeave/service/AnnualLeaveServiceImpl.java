package com.study.miniProjectV2.annualLeave.service;

import com.study.miniProjectV2.annualLeave.entity.AnnualLeave;
//import com.study.miniProjectV2.annualLeave.repository.AnnualLeaveRepository;
import com.study.miniProjectV2.annualLeave.repository.AnnualLeaveRepository;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnualLeaveServiceImpl implements AnnualLeaveService{
    private final AnnualLeaveRepository annualLeaveRepository;

    @Override
    public void createAnnualLeave(User newUser, Team team) {
        AnnualLeave annualLeave = AnnualLeave.of(newUser, team);
        annualLeaveRepository.save(annualLeave);
    }
}
