package kr.ac.kopo.minju_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "schedule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @Column
    private int schId;

    @Column
    private String userId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int repeats;

    @Column
    private int notice;

    @Column
    private String kind;
}
