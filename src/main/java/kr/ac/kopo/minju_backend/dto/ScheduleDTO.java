package kr.ac.kopo.minju_backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private String id;
    private String name;
    private String details;
    private String color;
    private String kind;
    private Date start;
    private Date end;
    private boolean timed;

    public boolean getTimed() {
        return timed;
    }
}
