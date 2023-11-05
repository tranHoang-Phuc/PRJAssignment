package com.thphuc.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
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
    @JoinColumn (name = "room-id")
    private Room room;
    @Column(name = "session-no")
    private Integer sessionNo;

    @ManyToOne
    @JoinColumn(name = "slot-id")
    private TimeSlot timeSlot;

    @Column(name = "attendance-status")
    private Boolean attendanceStatus;
    @Column(name = "date")
    private Date date;
    @Column(name = "event")
    private String event;

}
