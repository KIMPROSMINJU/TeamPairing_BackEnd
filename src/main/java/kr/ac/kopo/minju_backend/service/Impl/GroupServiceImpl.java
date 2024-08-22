package kr.ac.kopo.minju_backend.service.Impl;

import kr.ac.kopo.minju_backend.dto.GroupDTO;
import kr.ac.kopo.minju_backend.dto.GroupUserDTO;
import kr.ac.kopo.minju_backend.entity.Group;
import kr.ac.kopo.minju_backend.repository.GroupRepository;
import kr.ac.kopo.minju_backend.service.GroupService;
import kr.ac.kopo.minju_backend.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    private GroupUserService groupUserService;

    public Group registerGroup(GroupDTO dto){
        Group group = dtoToEntity(dto);
        return groupRepository.save(group);
    };

    // 그룹 참여
    public Optional<Group> joinGroup(GroupDTO dto, GroupUserDTO userDTO){
        Optional<Group> optionalGroup = groupRepository.findById(dto.getId());
        if (optionalGroup.isPresent()) {
            GroupUserDTO groupUserDTO = GroupUserDTO.builder()
                    .groupCode(userDTO.getGroupCode())
                    .memberId(userDTO.getMemberId())
                    .build();
            groupUserService.joinGroup(groupUserDTO);
        }
        return optionalGroup;
    };

    // 그룹 탈퇴
    public Optional<Group> leaveGroup(GroupDTO dto, GroupUserDTO userDTO) {
        Optional<Group> optionalGroup = groupRepository.findById(dto.getId());
        if (optionalGroup.isPresent()) {
            groupUserService.leaveGroup(userDTO.getGroupCode(), userDTO.getMemberId());
        }
        return optionalGroup;
    };

    // 그룹 수정
    public Optional<Group> updateGroup(GroupDTO dto) {
        Optional<Group> optionalGroup = groupRepository.findById(dto.getId());
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            group.setGroup_item(dto.getGroup_item());
            groupRepository.save(group);
            return Optional.of(group);
        } else {
            return Optional.empty();
        }
    }

    // 그룹 삭제
    public void deleteGroup(GroupDTO dto){
        groupRepository.deleteById(dto.getId());
    };

    public List<Group> findAllGroup(){
        return groupRepository.findAll();
    };

    public Optional<Group> findById(String id){
        return groupRepository.findById(id);
    }
}
