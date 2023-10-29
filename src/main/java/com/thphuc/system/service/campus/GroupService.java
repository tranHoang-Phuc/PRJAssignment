package com.thphuc.system.service.campus;

import com.thphuc.system.dto.GroupDTO;
import com.thphuc.system.model.Group;
import com.thphuc.system.repository.campus.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupDTO> getGroupByCouseSemester(String courseName, String semester) {
        List<Group> groups = groupRepository.getGroupBySemesterCourse(courseName, semester);
        return converToDTO(groups);
    }

    public List<GroupDTO> converToDTO(List<Group> groups) {
        List<GroupDTO> groupDTOS = new ArrayList<>();
        for (Group group : groups) {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setGroupID(group.getGroupID());
            groupDTO.setGroupName(group.getGroupName());
            groupDTOS.add(groupDTO);
        }
        return groupDTOS;
    }

}
