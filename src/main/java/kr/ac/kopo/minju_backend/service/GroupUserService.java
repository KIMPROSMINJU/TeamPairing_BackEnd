package kr.ac.kopo.minju_backend.service;

import kr.ac.kopo.minju_backend.dto.GroupUserDTO;
import kr.ac.kopo.minju_backend.entity.GroupUser;

public interface GroupUserService {
    // 사용자 참여
    void joinGroup(GroupUserDTO groupUserDTO);

    // 사용자 탈퇴
    void leaveGroup(String groupCode, String memberId);

    default GroupUser dtoToEntity(GroupUserDTO dto){
        return GroupUser.builder()
                .groupCode(dto.getGroupCode())
                .memberId(dto.getMemberId())
                .build();
    }

    default GroupUserDTO entityToDto(GroupUser entity){
        return GroupUserDTO.builder()
                .groupCode(entity.getGroupCode())
                .memberId(entity.getMemberId())
                .build();
    }
}
