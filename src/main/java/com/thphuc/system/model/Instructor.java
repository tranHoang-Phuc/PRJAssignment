package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Instructor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor {
    @Id
    @Column(name = "instructor-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorID;
    @Column(name = "icode")
    private String iCode;
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
    @Column(name = "address")
    private String address;
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
