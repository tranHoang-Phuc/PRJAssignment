package com.thphuc.system.resource;

import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.lesson.LessonService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("student/report")

public class StudentResource {
    @GET
    @Path("schedule-of-week/{studentCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LessonDTO> getScheduleOfWeek(@PathParam("studentCode") String studentCode) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<LessonDTO> lessons = lessonService.getStudentScheduleOfWeek(studentCode);
        return lessons;
    }
    @GET
    @Path("schedule-of-week/{studentCode}/{monday}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LessonDTO> getScheduleOfWeek(@PathParam("studentCode") String studentCode,@PathParam("monday") String monday) {
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        List<LessonDTO> lessons = lessonService.getStudentScheduleOfWeek(studentCode, monday);
        return lessons;
    }
}
