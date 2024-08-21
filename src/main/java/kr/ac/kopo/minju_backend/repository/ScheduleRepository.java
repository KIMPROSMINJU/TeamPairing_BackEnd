package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> deleteScheduleBySchId(int schId);
    Optional<Schedule> findScheduleBySchId(int schId);
    Optional<Schedule> findScheduleByStartDate(Date startDate);
    Optional<Schedule> findScheduleByTitle(String title);
    Optional<Schedule> findScheduleByKind(String kind);
}
