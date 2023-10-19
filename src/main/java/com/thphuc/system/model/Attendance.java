package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
@Entity
@Table(name = "Attendance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attendance {
    @Id
    @ManyToOne
    @JoinColumn(name = "sid")
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name = "lesson-id")
    private Lesson lesson;
    @Column(name = "status")
    private Integer status;
    @Column(name = "record-time")
    private Time recordedTime;
    @Column(name = "record-day")
    private Date recordedDay;
    @Column(name = "comment")
    private String comment;
}
