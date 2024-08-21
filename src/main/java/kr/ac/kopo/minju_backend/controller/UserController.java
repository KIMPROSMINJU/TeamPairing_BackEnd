package kr.ac.kopo.minju_backend.controller;

import kr.ac.kopo.minju_backend.dto.UserDTO;
import kr.ac.kopo.minju_backend.entity.User;
import kr.ac.kopo.minju_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<UserDTO> getAllUsers() {
        return userService.findAllUser().stream()
                .map(userService::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findby_id/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = userService.entityToDto(user.get());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        UserDTO createdUserDTO = userService.entityToDto(user);
        return ResponseEntity.ok(createdUserDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDetails) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPw(userDetails.getPw());
            existingUser.setBirth(userDetails.getBirth());
            existingUser.setGender(userDetails.getGender());
            User updatedUser = userService.saveUser(existingUser);
            UserDTO updatedUserDTO = userService.entityToDto(updatedUser);
            return ResponseEntity.ok(updatedUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/signout/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.loginUser(userDTO);
        if (user.isPresent()) {
            UserDTO loggedInUserDTO = userService.entityToDto(user.get());
            return ResponseEntity.ok(loggedInUserDTO);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/find_id")
    public ResponseEntity<UserDTO> findIdByNameAndEmail(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.findIdbyNameAndEmail(userDTO);
        if (user.isPresent()) {
            UserDTO foundUserDTO = userService.entityToDto(user.get());
            return ResponseEntity.ok(foundUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/find_pw")
    public ResponseEntity<UserDTO> updatePassword(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.updatePw(userDTO);
        if (user.isPresent()) {
            UserDTO updatedUserDTO = userService.entityToDto(user.get());
            return ResponseEntity.ok(updatedUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update_email")
    public ResponseEntity<UserDTO> updateEmail(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.updateEmail(userDTO);
        if (user.isPresent()) {
            UserDTO updatedUserDTO = userService.entityToDto(user.get());
            return ResponseEntity.ok(updatedUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestBody UserDTO userDTO) {
        userService.logoutUser(userDTO);
        return ResponseEntity.noContent().build();
    }
}
