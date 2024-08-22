package kr.ac.kopo.minju_backend.service.Impl;

import kr.ac.kopo.minju_backend.dto.UserDTO;
import kr.ac.kopo.minju_backend.entity.User;
import kr.ac.kopo.minju_backend.repository.UserRepository;
import kr.ac.kopo.minju_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDTO dto) {
        User user = dtoToEntity(dto);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> loginUser(UserDTO dto) {
        return userRepository.findUserByIdAndPassword(dto.getName(), dto.getPassword());
    }

    @Override
    public Optional<User> findIdbyNameAndEmail(UserDTO dto) {
        return userRepository.findUserByNameAndEmail(dto.getName(), dto.getEmail());
    }

    @Override
    public Optional<User> updatePw(UserDTO dto) {
        Optional<User> optionalUser = userRepository.findUserById(dto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(dto.getPassword());
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> updateEmail(UserDTO dto) {
        Optional<User> optionalUser = userRepository.findUserById(dto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(dto.getEmail());
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(UserDTO dto) {
        userRepository.deleteUserById(dto.getId());
    }

    @Override
    public void logoutUser(UserDTO dto) {
        // 로그아웃 로직은 클라이언트에서 세션/토큰을 삭제하는 방식으로 처리
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteUserById(id);
    }
}
