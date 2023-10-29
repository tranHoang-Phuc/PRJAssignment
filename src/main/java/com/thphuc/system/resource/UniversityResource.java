package com.thphuc.system.resource;

import com.thphuc.system.dto.*;
import com.thphuc.system.model.Course;
import com.thphuc.system.model.Semester;
import com.thphuc.system.repository.campus.*;
import com.thphuc.system.service.campus.GroupService;
import com.thphuc.system.service.campus.SemesterService;
import com.thphuc.system.service.student.StudentService;
import com.thphuc.system.service.teacher.TeacherService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("university")
public class UniversityResource {
    @GET
    @Path("semester")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SemesterDTO> getAllSemester() {
        SemesterRepository semesterRepository = new SemesterRepository();
        SemesterService semesterService = new SemesterService(semesterRepository);
        return semesterService.getAll();
    }

    @GET
    @Path("course/{semester}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllCourseOfSemester(@PathParam("semester") String semester) {
        CourseRepository courseRepository = new CourseRepository();
        return courseRepository.getCourseBySemester(semester);
    }

    @GET
    @Path("student/{semester}/{course}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GroupDTO> getGroupByCourseSemester(@PathParam("semester") String semester, @PathParam("course") String course) {
        GroupRepository groupRepository = new GroupRepository();
        GroupService groupService = new GroupService(groupRepository);
        return groupService.getGroupByCouseSemester(course, semester);
    }

    @GET
    @Path("student/{semester}/{course}/{group}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentAttendanceDTOResponse> getAttendanceByGroup(@PathParam("semester") String semester, @PathParam("course") String courseName, @PathParam("group") String group ) {
        List<StudentAttendanceDTOResponse> studentAttendanceDTOResponses = new ArrayList<>();
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        TeacherService teacherService = new TeacherService(attendanceRepository);
        Map<StudentDTO, List<AttendanceDTO>> mapping =  teacherService.getAttendanceForStudent(semester, courseName, group);
        for (Map.Entry<StudentDTO, List<AttendanceDTO>> entry : mapping.entrySet()) {
            StudentAttendanceDTOResponse studentAttendanceDTOResponse = new StudentAttendanceDTOResponse();
            studentAttendanceDTOResponse.setStudentDTO(entry.getKey());
            studentAttendanceDTOResponse.setAttendanceDTOS(entry.getValue());
            studentAttendanceDTOResponses.add(studentAttendanceDTOResponse);
        }
        return  studentAttendanceDTOResponses;
    }
}
