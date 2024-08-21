package kr.ac.kopo.minju_backend.service.Impl;

import kr.ac.kopo.minju_backend.dto.ScheduleDTO;
import kr.ac.kopo.minju_backend.entity.Schedule;
import kr.ac.kopo.minju_backend.repository.ScheduleRepository;
import kr.ac.kopo.minju_backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 스케줄 등록
    public Schedule registerSchedule(ScheduleDTO dto) {
        Schedule schedule = dtoToEntity(dto);
        return scheduleRepository.save(schedule);
    };

    // 스케줄 삭제
    public void deleteSchedule(ScheduleDTO dto) {
        scheduleRepository.deleteScheduleBySchId(dto.getSchId());
    };

    // 스케줄 수정
    public Optional<Schedule> updateSchedule(ScheduleDTO dto) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleBySchId(dto.getSchId());
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setTitle(dto.getTitle());
            schedule.setContent(dto.getContent());
            schedule.setKind(dto.getKind());
            schedule.setNotice(dto.getNotice());
            schedule.setRepeats(dto.getRepeats());
            schedule.setStartDate(dto.getStartDate());
            schedule.setEndDate(dto.getEndDate());
            scheduleRepository.save(schedule);
            return Optional.of(schedule);
        } else {
            return Optional.empty();
        }
    };

    public Optional<Schedule> findScheduleBySchId(int schId){
        return scheduleRepository.findScheduleBySchId(schId);
    };
    public Optional<Schedule> findScheduleByStartDate(Date startDate){
        return scheduleRepository.findScheduleByStartDate(startDate);
    };
    public Optional<Schedule> findScheduleByTitle(String title){
        return scheduleRepository.findScheduleByTitle(title);
    };
    public Optional<Schedule> findScheduleByKind(String kind){
        return scheduleRepository.findScheduleByKind(kind);
    };
}
