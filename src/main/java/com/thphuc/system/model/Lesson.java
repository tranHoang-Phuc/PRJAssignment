package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Entity
@Table(name = "Lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lesson {
    @Id
    @Column(name = "lesson-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonID;
    @ManyToOne
    @JoinColumn(name = "group-id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "instructor-id")
    private Instructor instructor;
    @ManyToOne
    @JoinColumn(name = "room-id")
    private Room room;
    private Integer sessionNo;
    @ManyToOne
    @JoinColumn(name = "slot-id")
    private TimeSlot timeSlot;
    private Boolean attendanceStatus;
    private Date date;

}
