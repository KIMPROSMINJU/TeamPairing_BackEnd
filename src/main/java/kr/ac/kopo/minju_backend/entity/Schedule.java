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
    private String id;

    @Column
    private String name;
    
    @Column
    private String details;
    
    @Column
    private String color;

    @Column
    private String kind;
    
    @Column
    private Date start;
    
    @Column
    private Date end;

    @Column
    private boolean timed;

    public boolean getTimed() {
        return timed;
    }
}
