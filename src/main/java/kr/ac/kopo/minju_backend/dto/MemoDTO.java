package kr.ac.kopo.minju_backend.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoDTO {
    private String memoId;
    private Date regDate;
    private Date modDate;
    private String memo;
}
