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

    Optional<Schedule> findScheduleBySchId(int schId);
    Optional<Schedule> findScheduleByStartDate(Date startDate);
    Optional<Schedule> findScheduleByTitle(String title);
    Optional<Schedule> findScheduleByKind(String kind);

    default Schedule dtoToEntity(ScheduleDTO dto) {
        return Schedule.builder()
                .schId(dto.getSchId())
                .userId(dto.getUserId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .title(dto.getTitle())
                .content(dto.getContent())
                .repeats(dto.getRepeats())
                .notice(dto.getNotice())
                .kind(dto.getKind())
                .build();
    }

    default ScheduleDTO entityToDto(Schedule entity) {
        return ScheduleDTO.builder()
                .schId(entity.getSchId())
                .userId(entity.getUserId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .title(entity.getTitle())
                .content(entity.getContent())
                .repeats(entity.getRepeats())
                .notice(entity.getNotice())
                .kind(entity.getKind())
                .build();
    }
}
