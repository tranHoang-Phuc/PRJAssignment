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
