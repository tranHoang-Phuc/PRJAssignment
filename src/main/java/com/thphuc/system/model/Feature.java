package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Feature")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feature {
    @Id
    @Column(name = "feature-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureId;
    @Column(name = "url")
    private String url;
    @ManyToMany
    @JoinTable(
            name = "RoleFeature",
            joinColumns = @JoinColumn(name = "feature-id", referencedColumnName = "feature-id"),
            inverseJoinColumns = @JoinColumn(name = "role-id", referencedColumnName = "role-id"))
    private Set<Role> roles;
}
