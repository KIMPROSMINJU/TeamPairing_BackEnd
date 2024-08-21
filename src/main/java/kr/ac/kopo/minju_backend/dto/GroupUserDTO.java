package kr.ac.kopo.minju_backend.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupUserDTO {
    private String groupCode;
    private String memberId;
}
