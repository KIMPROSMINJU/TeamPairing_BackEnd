package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
    void deleteGroupUserByGroupCodeAndMemberId(String groupCode, String memberId);
}
