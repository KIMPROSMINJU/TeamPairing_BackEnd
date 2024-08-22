package kr.ac.kopo.minju_backend.service;

import kr.ac.kopo.minju_backend.dto.UserDTO;
import kr.ac.kopo.minju_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // 회원가입
    User registerUser(UserDTO dto);

    // 로그인
    Optional<User> loginUser(UserDTO dto);

    // 아이디 찾기
    Optional<User> findIdbyNameAndEmail(UserDTO dto);

    // 비밀번호 수정
    Optional<User> updatePw(UserDTO dto);

    // 이메일 수정
    Optional<User> updateEmail(UserDTO dto);

    // 회원 탈퇴
    void deleteUser(UserDTO dto);

    // 로그아웃
    void logoutUser(UserDTO dto);

    // 모든 사용자 조회
    List<User> findAllUser();

    // ID로 사용자 조회
    Optional<User> findById(String id);

    // 사용자 저장
    User saveUser(User user);

    // ID로 사용자 삭제
    void deleteById(String id);

    // DTO를 Entity로 변환
    default User dtoToEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .member_id(dto.getMember_id())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .name(dto.getName())
                .birth(dto.getBirth())
                .gender(dto.getGender())
                .build();
    }

    // Entity를 DTO로 변환
    default UserDTO entityToDto(User entity){
        return UserDTO.builder()
                .id(entity.getId())
                .member_id(entity.getMember_id())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .name(entity.getName())
                .birth(entity.getBirth())
                .gender(entity.getGender())
                .build();
    }
}
