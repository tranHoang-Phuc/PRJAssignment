package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonDTO {
    private int lessonID;
    private String groupname;
    private String courseName;
    private String instructorCode;
    private String roomName;
    private String timeSlot;
    private String timeLast;
    private Date date;
    private int sessionNo;
    private Boolean attendanceStatus;
}
