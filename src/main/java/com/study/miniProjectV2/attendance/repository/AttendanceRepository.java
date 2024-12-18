package com.study.miniProjectV2.attendance.repository;

import com.study.miniProjectV2.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query(value = "SELECT * FROM attendance " +
            "ORDER BY check_in_time " +
            "DESC LIMIT 1", nativeQuery = true)
    public Optional<Attendance> findLatestAttendance();

    @Query("SELECT a FROM Attendance a WHERE FUNCTION('DATE', a.checkInTime) = :date")
    public Optional<Attendance> findByCheckInDate(@Param("date") String checkInDate);
}
