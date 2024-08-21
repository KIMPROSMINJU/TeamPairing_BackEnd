package kr.ac.kopo.minju_backend.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String pw;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private char gender;
}