package com.thphuc.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private int sid;
    private String scode;
    private String firstName;
    private String lastName;
    private Date dob;
    private boolean gender;
    private String phone;
    private String email;
    private String img;
    private AccountDTO account;
}
