package kr.ac.kopo.minju_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "groupuser")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupUser {
    @Id
    @Column
    private String groupCode;

    @Column
    private String memberId;

    public String getMemberId(){
        return memberId;
    }

    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
}
