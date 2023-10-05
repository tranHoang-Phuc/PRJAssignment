package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @Column(name = "course-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;
    @Column(name = "course-name")
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "dept-id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "semester-id")
    private Semester semester;
}
