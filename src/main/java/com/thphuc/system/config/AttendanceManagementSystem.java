/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.config;

import com.thphuc.system.filter.CorsFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author tran Hoang Phuc
 */
@ApplicationPath("api")
public class AttendanceManagementSystem extends ResourceConfig{

    public AttendanceManagementSystem() {
        register(CorsFilter.class);
        packages("com.thphuc.system.resource");
    }
    
}
