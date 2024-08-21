package kr.ac.kopo.minju_backend.service.Impl;

import kr.ac.kopo.minju_backend.dto.GroupUserDTO;
import kr.ac.kopo.minju_backend.entity.GroupUser;
import kr.ac.kopo.minju_backend.repository.GroupUserRepository;
import kr.ac.kopo.minju_backend.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserServiceImpl implements GroupUserService {

    private final GroupUserRepository groupUserRepository;

    @Autowired
    public GroupUserServiceImpl(GroupUserRepository groupUserRepository) {
        this.groupUserRepository = groupUserRepository;
    }

    @Override
    public void joinGroup(GroupUserDTO groupUserDTO) {
        GroupUser groupUser = dtoToEntity(groupUserDTO);
        groupUserRepository.save(groupUser);
    }

    @Override
    public void leaveGroup(String groupCode, String memberId) {
        groupUserRepository.deleteGroupUserByGroupCodeAndMemberId(groupCode, memberId);
    }
}
