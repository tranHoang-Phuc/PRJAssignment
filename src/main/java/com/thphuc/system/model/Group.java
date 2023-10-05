package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @Column(name = "group-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupID;
    @Column(name = "group-name")
    private String groupName;
    @ManyToOne
    @JoinColumn(name = "course-id")
    private Course course;
}
