package com.thphuc.system.resource;

import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.CourseDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.model.Attendance;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.CourseRepository;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.campus.CourseService;
import com.thphuc.system.service.lesson.LessonService;
import com.thphuc.system.service.student.StudentService;
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


    @GET
    @Path("list-course/{semester}/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseDTO> getListCourseOfStudent(@PathParam("semester") String semester,@PathParam("sid") String sid) {
        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);
        List<CourseDTO> courses = courseService.getCourseBySemesterAndStudentCode(semester, sid);
        return courses;
    }

    @GET
    @Path("attendance/{semester}/{course}/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AttendanceDTO> getAttendanceByCourseAndSid(@PathParam("semester") String semester,@PathParam("course") String course,@PathParam("sid") String sid) {
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        StudentService studentService = new StudentService(attendanceRepository);
        return studentService.getAttendanceByCourseAndSid(semester, course, sid);
    }
}
