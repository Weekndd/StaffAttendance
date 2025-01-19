package com.study.miniProjectV2.annualLeave.dto;

import com.study.miniProjectV2.annualLeave.entity.AnnualLeave;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RequestSubmitAnnualLeaveDto {
    private long userId;
    private long teamId;
    private LocalDate startDay;
    private LocalDate endDay;

}
