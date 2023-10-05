/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
    @ManyToOne
    @JoinColumn(name = "cid")
    private Campus campus;
    @OneToOne
    @JoinColumn(name = "account-id")
    private Account account;
}
