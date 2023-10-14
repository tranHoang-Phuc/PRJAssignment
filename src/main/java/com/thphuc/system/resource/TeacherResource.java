/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.resource;

import com.thphuc.system.model.Lesson;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.campus.LessonService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.Date;
import java.util.List;

/**
 * @author tran Hoang Phuc
 */
@Path("teacher/report")
public class TeacherResource {

    @GET
    @Path("schedule-of-week/{studentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lesson> getScheduleOfWeek(@PathParam("studentID") String studentID) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<Lesson> lessons = lessonService.getScheduleOfWeek(studentID);
        return lessons;
    }

    @GET
    @Path("schedule-of-week/{studentID}/{monday}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lesson> getScheduleOfWeek(@PathParam("studentID") String studentID,@PathParam("monday") String date) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<Lesson> lessons = lessonService.getScheduleOfWeek(studentID, date);
        return lessons;
    }


}
