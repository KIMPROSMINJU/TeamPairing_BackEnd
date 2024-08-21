package kr.ac.kopo.minju_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "memo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id
    @Column
    private String memoId;

    @Column
    private Date regDate;

    @Column
    private Date modDate;

    @Column
    private String memo;

    public String getMemoId(){
        return memoId;
    }

    public void setRegDate(Date regDate){
        this.regDate = regDate;
    }

    public Date getRegDate(){
        return regDate;
    }

    public void setModDate(Date modDate){
        this.modDate = modDate;
    }

    public Date getModDate(){
        return modDate;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getMemo(){
        return memo;
    }
}
