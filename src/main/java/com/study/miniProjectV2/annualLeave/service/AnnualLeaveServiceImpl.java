package com.study.miniProjectV2.annualLeave.service;

import com.study.miniProjectV2.annualLeave.dto.RequestSubmitAnnualLeaveDto;
import com.study.miniProjectV2.annualLeave.entity.AnnualLeave;
import com.study.miniProjectV2.annualLeave.repository.AnnualLeaveRepository;
import com.study.miniProjectV2.attendance.service.AttendanceService;
import com.study.miniProjectV2.common.exception.InsufficientAnnualLeaveException;
import com.study.miniProjectV2.common.exception.NotFoundException;
import com.study.miniProjectV2.common.response.BaseResponseStatus;
import com.study.miniProjectV2.team.entity.Team;
import com.study.miniProjectV2.user.entity.User;
import com.study.miniProjectV2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnualLeaveServiceImpl implements AnnualLeaveService{
    private final AttendanceService attendanceService;
    private final AnnualLeaveRepository annualLeaveRepository;
    private final UserService userService;

    @Override
    public void createAnnualLeave(User newUser, Team team) {
        AnnualLeave annualLeave = AnnualLeave.of(newUser, team);
        annualLeaveRepository.save(annualLeave);
    }

    @Override
    public void submitAnnualLeave(RequestSubmitAnnualLeaveDto requestSubmitAnnualLeaveDto) {
        User user = userService.getUserById(requestSubmitAnnualLeaveDto.getUserId());
        AnnualLeave annualLeave = getAnnualLeaveByUserId(user.getId());
        //남은 연차일 수 확인
        if(annualLeave.checkRemainingDays()) {
            throw new InsufficientAnnualLeaveException(BaseResponseStatus.INSUFFICIENT_ANNUAL_LEAVE);
        }
        //연차 마감일 확인
        if(annualLeave.checkAnnualDeadLine(requestSubmitAnnualLeaveDto.getStartDay())) {
            throw new IllegalArgumentException(BaseResponseStatus.EXCEED_ANNUAL_LEAVE_DEADLINE.getMessage());
        }
        attendanceService.submitAnnualLeave(user, requestSubmitAnnualLeaveDto.getStartDay());
        annualLeave.useAnnualLeave();
        annualLeaveRepository.save(annualLeave);
    }

    @Override
    public AnnualLeave getAnnualLeaveByUserId(long userId) {
        AnnualLeave annualLeave = annualLeaveRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException(BaseResponseStatus.NOT_FOUND_ANNUAL_LEAVE));
        return annualLeave;
    }

}
