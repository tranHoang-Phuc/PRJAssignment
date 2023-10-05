package com.thphuc.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "TimeSlot")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeSlot {
    @Id
    @Column(name = "slot-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeSlotID;
    @Column(name = "start")
    private Time startTime;
    @Column(name = "end")
    private Time endTime;
}
