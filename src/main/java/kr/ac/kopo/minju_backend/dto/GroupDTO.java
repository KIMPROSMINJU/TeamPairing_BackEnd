package kr.ac.kopo.minju_backend.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {
    private String groupCode;
    private String groupName;
    private String ownerId;
}
