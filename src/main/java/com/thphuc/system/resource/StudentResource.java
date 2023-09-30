/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * @author tran Hoang Phuc
 */
@Path("student/report")
public class StudentResource {

    @GET
    @Path("schedule-of-week")
    @Produces(MediaType.APPLICATION_JSON)
    public String getScheduleOfWeek() {
        return "Hello I am phuc";
    }

    @GET
    @Path("schedule-of-week/{monday}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getScheduleOfWeek(@PathParam("monday") String date) {
        return date;
    }


}
