package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstructorDTO {
    private int instructorID;
    private String iCode;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private String address;
    private String email;
    private String img;
    private AccountDTO account;
}
