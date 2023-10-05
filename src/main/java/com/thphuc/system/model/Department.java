package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "dept-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;
    @Column(name = "dept-name")
    private String departmentName;
}
