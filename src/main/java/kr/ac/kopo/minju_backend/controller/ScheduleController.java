package kr.ac.kopo.minju_backend.controller;

import kr.ac.kopo.minju_backend.dto.ScheduleDTO;
import kr.ac.kopo.minju_backend.entity.Schedule;
import kr.ac.kopo.minju_backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/schdeule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping("/findby_schid/{schId}")
    public ResponseEntity<ScheduleDTO> getScheduleBySchId(@PathVariable int schId) {
        Optional<Schedule> schedule = scheduleService.findScheduleBySchId(schId);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return ResponseEntity.ok(scheduleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_startdate/{startDate}")
    public ResponseEntity<ScheduleDTO> getScheduleByStartDate(@PathVariable Date startDate) {
        Optional<Schedule> schedule = scheduleService.findScheduleByStartDate(startDate);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return ResponseEntity.ok(scheduleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_title/{title}")
    public ResponseEntity<ScheduleDTO> getScheduleByTitle(@PathVariable String title) {
        Optional<Schedule> schedule = scheduleService.findScheduleByTitle(title);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return ResponseEntity.ok(scheduleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findby_kind/{kind}")
    public ResponseEntity<ScheduleDTO> getScheduleByKind(@PathVariable String kind) {
        Optional<Schedule> schedule = scheduleService.findScheduleByKind(kind);
        if (schedule.isPresent()){
            ScheduleDTO scheduleDTO = scheduleService.entityToDto(schedule.get());
            return ResponseEntity.ok(scheduleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.registerSchedule(scheduleDTO);
        ScheduleDTO createdSchedule = scheduleService.entityToDto(schedule);
        return ResponseEntity.ok(createdSchedule);
    }

    @PutMapping("/update")
    public ResponseEntity<ScheduleDTO> updateSchedule(@RequestBody ScheduleDTO scheduleDetails) {
        Optional<Schedule> updatedSchedule = scheduleService.updateSchedule(scheduleDetails);
        if (updatedSchedule.isPresent()) {
            ScheduleDTO updatedScheduleDTO = scheduleService.entityToDto(updatedSchedule.get());
            return ResponseEntity.ok(updatedScheduleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        if (scheduleService.findScheduleBySchId(scheduleDTO.getSchId()).isPresent()) {
            scheduleService.deleteSchedule(scheduleDTO);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
