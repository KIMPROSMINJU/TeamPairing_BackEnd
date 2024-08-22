package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> deleteScheduleById(String id);
    Optional<Schedule> findScheduleById(String id);
    Optional<Schedule> findScheduleByStart(Date start);
    Optional<Schedule> findScheduleByName(String name);
    Optional<Schedule> findScheduleByKind(String kind);
}
