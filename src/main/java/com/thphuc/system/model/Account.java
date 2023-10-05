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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tran Hoang Phuc
 */
@Entity
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @Column(name = "account-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role-id")
    private Role role;
}
