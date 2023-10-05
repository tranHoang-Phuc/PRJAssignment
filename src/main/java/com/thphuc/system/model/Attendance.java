package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer status;
    private Timestamp recordedTime;
}