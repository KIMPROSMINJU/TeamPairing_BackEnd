package kr.ac.kopo.minju_backend.service;

import kr.ac.kopo.minju_backend.dto.ScheduleDTO;
import kr.ac.kopo.minju_backend.entity.Schedule;

import java.sql.Date;
import java.util.Optional;

public interface ScheduleService {
    // 스케줄 등록
    Schedule registerSchedule(ScheduleDTO dto);

    // 스케줄 삭제
    void deleteSchedule(ScheduleDTO dto);

    // 스케줄 수정
    Optional<Schedule> updateSchedule(ScheduleDTO dto);

    Optional<Schedule> findScheduleById(String id);
    Optional<Schedule> findScheduleByStart(Date start);
    Optional<Schedule> findScheduleByName(String name);
    Optional<Schedule> findScheduleByKind(String kind);

    default Schedule dtoToEntity(ScheduleDTO dto) {
        return Schedule.builder()
                .id(dto.getId())
                .name(dto.getName())
                .details(dto.getDetails())
                .color(dto.getColor())
                .kind(dto.getKind())
                .start(dto.getStart())
                .end(dto.getEnd())
                .timed(dto.getTimed())
                .build();
    }

    default ScheduleDTO entityToDto(Schedule entity) {
        return ScheduleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .details(entity.getDetails())
                .color(entity.getColor())
                .kind(entity.getKind())
                .start(entity.getStart())
                .end(entity.getEnd())
                .timed(entity.getTimed())
                .build();
    }
}
