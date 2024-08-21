package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // 그룹코드로 그룹 검색
    Optional<Group> findByGroupCode(String groupCode);

    // 그룹코드로 그룹 삭제
    Optional<Group> deleteByGroupCode(String groupCode);
}
