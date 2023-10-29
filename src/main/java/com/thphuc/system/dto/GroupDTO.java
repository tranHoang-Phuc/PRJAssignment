package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupDTO {
    private int groupID;
    private String groupName;
    private CourseDTO courseDTO;
    private Set<StudentDTO> studentDTOs;
}
