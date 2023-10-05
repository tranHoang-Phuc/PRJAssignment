package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "StudentGroup")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentGroup {
    @Id
    @ManyToOne
    @JoinColumn(name = "sid")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "group-id")
    private Group group;
}
