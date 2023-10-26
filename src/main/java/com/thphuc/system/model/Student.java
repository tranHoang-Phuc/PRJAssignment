/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import java.util.List;
import java.util.Set;

/**
 * @author tran Hoang Phuc
 */
@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    @Column(name = "scode")
    private String scode;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "img")
    private String img;

    @OneToOne
    @JoinColumn(name = "account-id")
    private Account account;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private Set<Group> groups;
}
