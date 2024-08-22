package kr.ac.kopo.minju_backend.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String member_id;
    private String password;
    private String email;
    private String name;
    private String birth;
    private String gender;
}