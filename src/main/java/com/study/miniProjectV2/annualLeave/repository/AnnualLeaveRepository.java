package com.study.miniProjectV2.annualLeave.repository;

import com.study.miniProjectV2.annualLeave.entity.AnnualLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnualLeaveRepository extends JpaRepository<AnnualLeave, Long> {
    Optional<AnnualLeave> findByUserId(long userId);
}
