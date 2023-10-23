package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceDTO {
    private String groupName;
    private String scode;
    private StudentDTO student;
    private LessonDTO lesson;
    private int slotId;
    private Date recordedDay;
    private Time recordedTime;
    private int status;
    private String comment;
    private String roomName;
}
