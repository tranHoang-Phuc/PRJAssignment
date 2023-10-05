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
