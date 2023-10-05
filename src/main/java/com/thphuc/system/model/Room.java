/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tran Hoang Phuc
 */
@Entity
@Table(name = "Room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @Column(name ="room-id")
    private int roomID;
    
    @Column(name = "room-name")
    private String roomName;
}
