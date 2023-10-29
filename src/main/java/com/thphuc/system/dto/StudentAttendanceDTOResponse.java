package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentAttendanceDTOResponse {
    private StudentDTO studentDTO;
    private List<AttendanceDTO> attendanceDTOS;
}
