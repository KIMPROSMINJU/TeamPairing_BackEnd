package kr.ac.kopo.minju_backend.repository;

import kr.ac.kopo.minju_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이름과 이메일로 사용자 검색
    Optional<User> findUserByNameAndEmail(String name, String email);

    // 아이디로 사용자 검색
    Optional<User> findUserById(String id);

    // 아이디와 이메일로 사용자 검색
    Optional<User> findUserByIdAndEmail(String id, String email);


    // 아이디와 비밀번호로 사용자 검색 (로그인용)
    Optional<User> findUserByIdAndPassword(String id, String password);

    // 아이디로 회원 탈퇴
    Optional<User> deleteUserById (String id);
}
