package kr.ac.kopo.minju_backend.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private int schId;
    private String userId;
    private Date startDate;
    private Date endDate;
    private String title;
    private String content;
    private int repeats;
    private int notice;
    private String kind;
}
