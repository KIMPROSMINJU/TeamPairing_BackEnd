package kr.ac.kopo.minju_backend.controller;

import kr.ac.kopo.minju_backend.dto.GroupDTO;
import kr.ac.kopo.minju_backend.dto.GroupUserDTO;
import kr.ac.kopo.minju_backend.entity.Group;
import kr.ac.kopo.minju_backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("findAll")
    public List<GroupDTO> getAllGroups(){
        return groupService.findAllGroup().stream()
                .map(groupService::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findby_groupcode/{id}")
    public ResponseEntity<GroupDTO> getGroupByGroupCode(@PathVariable String id){
        Optional<Group> group = groupService.findById(id);
        if (group.isPresent()){
            GroupDTO groupDTO = groupService.entityToDto(group.get());
            return ResponseEntity.ok(groupDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO){
        Group group = groupService.registerGroup(groupDTO);
        GroupDTO createdGroupDTO = groupService.entityToDto(group);
        return ResponseEntity.ok(createdGroupDTO);
    }

    @PostMapping("/join")
    public ResponseEntity<GroupDTO> joinGroup(@RequestBody GroupDTO groupDTO, @RequestBody GroupUserDTO groupUserDTO) {
        Optional<Group> optionalGroup = groupService.joinGroup(groupDTO, groupUserDTO);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            GroupDTO responseDTO = GroupDTO.builder()
                    .id(group.getId())
                    .group_item(group.getGroup_item())
                    .build();
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/leave")
    public ResponseEntity<GroupDTO> leaveGroup(@RequestBody GroupDTO groupDTO, @RequestBody GroupUserDTO groupUserDTO) {
        Optional<Group> optionalGroup = groupService.leaveGroup(groupDTO, groupUserDTO);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            GroupDTO responseDTO = GroupDTO.builder()
                    .id(group.getId())
                    .group_item(group.getGroup_item())
                    .build();
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDetails) {
        Optional<Group> updatedGroup = groupService.updateGroup(groupDetails);
        if (updatedGroup.isPresent()) {
            GroupDTO updatedGroupDTO = groupService.entityToDto(updatedGroup.get());
            return ResponseEntity.ok(updatedGroupDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteGroup(@RequestBody GroupDTO groupDTO){
        if (groupService.findById(groupDTO.getId()).isPresent()){
            groupService.deleteGroup(groupDTO);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
