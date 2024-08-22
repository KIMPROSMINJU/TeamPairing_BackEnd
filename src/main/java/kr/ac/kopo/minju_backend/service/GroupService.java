package kr.ac.kopo.minju_backend.service;


import kr.ac.kopo.minju_backend.dto.GroupDTO;
import kr.ac.kopo.minju_backend.dto.GroupUserDTO;
import kr.ac.kopo.minju_backend.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    // 그룹 등록
    Group registerGroup(GroupDTO dto);

    // 그룹 참여
    Optional<Group> joinGroup(GroupDTO dto, GroupUserDTO userDTO);

    // 그룹 탈퇴
    Optional<Group> leaveGroup(GroupDTO dto, GroupUserDTO userDTO);

    // 그룹 수정
    Optional<Group> updateGroup(GroupDTO dto);

    // 그룹 삭제
    void deleteGroup(GroupDTO groupDTO);

    List<Group> findAllGroup();

    Optional<Group> findById(String id);

    default Group dtoToEntity(GroupDTO dto){
        return Group.builder()
                .id(dto.getId())
                .group_item(dto.getGroup_item())
                .build();
    }

    default GroupDTO entityToDto(Group entity){
        return GroupDTO.builder()
                .id(entity.getId())
                .group_item(entity.getGroup_item())
                .build();
    }
}
