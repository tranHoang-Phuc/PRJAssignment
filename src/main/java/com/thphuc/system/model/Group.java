package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "GroupClass")
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
    @ManyToMany
    @JoinTable(
            name = "StudentGroup",
            joinColumns = @JoinColumn(name = "group-id", referencedColumnName = "group-id"),
            inverseJoinColumns = @JoinColumn(name = "sid", referencedColumnName = "sid"))
    private Set<Student> students;
}
