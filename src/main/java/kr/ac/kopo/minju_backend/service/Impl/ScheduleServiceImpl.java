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
        scheduleRepository.deleteScheduleById(dto.getId());
    };

    // 스케줄 수정
    public Optional<Schedule> updateSchedule(ScheduleDTO dto) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(dto.getId());
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setId(dto.getId());
            schedule.setName(dto.getName());
            schedule.setDetails(dto.getDetails());
            schedule.setColor(dto.getColor());
            schedule.setKind(dto.getKind());
            schedule.setStart(dto.getStart());
            schedule.setEnd(dto.getEnd());
            schedule.setTimed(dto.getTimed());
            scheduleRepository.save(schedule);
            return Optional.of(schedule);
        } else {
            return Optional.empty();
        }
    };

    public Optional<Schedule> findScheduleById(String id){
        return scheduleRepository.findScheduleById(id);
    };
    public Optional<Schedule> findScheduleByStart(Date start){
        return scheduleRepository.findScheduleByStart(start);
    };
    public Optional<Schedule> findScheduleByName(String name){
        return scheduleRepository.findScheduleByName(name);
    };
    public Optional<Schedule> findScheduleByKind(String kind){
        return scheduleRepository.findScheduleByKind(kind);
    };
}
