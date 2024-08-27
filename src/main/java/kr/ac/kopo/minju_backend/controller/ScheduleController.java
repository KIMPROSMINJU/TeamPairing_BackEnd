package kr.ac.kopo.minju_backend.controller;

import kr.ac.kopo.minju_backend.dto.ScheduleDTO;
import kr.ac.kopo.minju_backend.entity.Schedule;
import kr.ac.kopo.minju_backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schdeule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

//    @GetMapping("/findAll")
//    public List<ScheduleDTO> getAllGroups(){
//        return scheduleService.findAll().stream()
//                .map(scheduleService::entityToDto)
//                .collect(Collectors.toList());
//    }

    // 일정 검색 기능 - 찾고자 하는 일정이 데이터베이스에 존재할 경우 해당 일정을 반환하고 존재하지 않을 경우 null값 반환
    @GetMapping("/findby_id/{id}")
    public ScheduleDTO getScheduleById(@PathVariable String id) {
        Optional<Schedule> schedule = scheduleService.findScheduleById(id);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return scheduleDTO;
        } else {
            return null;
        }
    }

    @GetMapping("/findby_start/{start}")
    public ScheduleDTO getScheduleByStart(@PathVariable Date start) {
        Optional<Schedule> schedule = scheduleService.findScheduleByStart(start);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return scheduleDTO;
        } else {
            return null;
        }
    }

    @GetMapping("/findby_name/{name}")
    public ScheduleDTO getScheduleByName(@PathVariable String name) {
        Optional<Schedule> schedule = scheduleService.findScheduleByName(name);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return scheduleDTO;
        } else {
            return null;
        }
    }

    @GetMapping("/findby_kind/{kind}")
    public ScheduleDTO getScheduleByKind(@PathVariable String kind) {
        Optional<Schedule> schedule = scheduleService.findScheduleByKind(kind);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return scheduleDTO;
        } else {
            return null;
        }
    }

    // 일정 등록 기능 - 생성된 일정 반환
    @PostMapping("/register")
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.registerSchedule(scheduleDTO);
        ScheduleDTO createdSchedule = scheduleService.entityToDto(schedule);
        return createdSchedule;
    }

    // 일정 수정 기능 - 수정된 일정 반환, 수정된 일정이 존재하지 않을 경우 null값 반환
    @PutMapping("/update")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDetails) {
        Optional<Schedule> updatedSchedule = scheduleService.updateSchedule(scheduleDetails);
        if (updatedSchedule.isPresent()) {
            ScheduleDTO updatedScheduleDTO = scheduleService.entityToDto(updatedSchedule.get());
            return updatedScheduleDTO;
        } else {
            return null;
        }
    }

    // 일정 삭제 기능 - 반환값 없음
    @DeleteMapping("/delete")
    public void deleteSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        if (scheduleService.findScheduleById(scheduleDTO.getId()).isPresent()) {
            scheduleService.deleteSchedule(scheduleDTO);
        }
    }
}
