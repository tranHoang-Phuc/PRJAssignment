package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Semester")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Semester {
    @Id
    @Column(name = "semester-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterID;
    @Column(name = "semester-name")
    private String semesterName;

}
