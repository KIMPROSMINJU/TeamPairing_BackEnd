package kr.ac.kopo.minju_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "user_group")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @Column
    private String groupCode;

    @Column
    private String groupName;

    @Column
    private String ownerId;

    public String getGroupCode(){
        return groupCode;
    }

    public void setGroupCode(String groupCode){
        this.groupCode = groupCode;
    }

    public String getGroupName(){
        return groupCode;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getOwnerId(){
        return ownerId;
    }
}
