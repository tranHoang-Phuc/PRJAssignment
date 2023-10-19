/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.resource;

import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.model.Lesson;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.lesson.LessonService;
import com.thphuc.system.service.teacher.TeacherService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * @author tran Hoang Phuc
 */
@Path("teacher/report")
public class TeacherResource {

    @GET
    @Path("schedule-of-week/{instructorCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LessonDTO> getScheduleOfWeek(@PathParam("instructorCode") String instructorCode) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<Lesson> lessons = lessonService.getScheduleOfWeek(instructorCode);
        return lessonService.convertToDTO(lessons);
    }

    @GET
    @Path("schedule-of-week/{instructorCode}/{monday}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LessonDTO> getScheduleOfWeek(@PathParam("instructorCode") String iCode,@PathParam("monday") String date) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<Lesson> lessons = lessonService.getScheduleOfWeek(iCode, date);
        return lessonService.convertToDTO(lessons);
    }

    @GET
    @Path("attendance/{lessonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AttendanceDTO> getAttendanceOfLesson(@PathParam("lessonId") String lessonId) {
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        TeacherService teacherService = new TeacherService(attendanceRepository);
        List<AttendanceDTO> attendanceDTOS = teacherService.getAttendanceByLessonId(Integer.parseInt(lessonId));
        return attendanceDTOS;
    }



}
