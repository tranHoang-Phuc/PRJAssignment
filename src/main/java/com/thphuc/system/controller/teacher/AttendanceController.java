package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.repository.campus.StudentRepository;
import com.thphuc.system.service.lesson.LessonService;
import com.thphuc.system.service.teacher.TeacherService;
import com.thphuc.system.util.DateTimeUtil;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Set;

public class AttendanceController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        LessonDTO lessonDTO = lessonService.getLessonById(lessonId);
        request.setAttribute("lesson", lessonDTO);
        request.setAttribute("lessonId", lessonId);
        request.getRequestDispatcher("../view/teacher/attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        StudentRepository studentRepository = new StudentRepository();
        LessonRepository lessonRepository = new LessonRepository();
        TeacherService teacherService = new TeacherService(attendanceRepository, studentRepository, lessonRepository);
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        String[] index = request.getParameterValues("index");
        for (String s: index) {
            int sid = Integer.parseInt(request.getParameter("sid" + s));
            String scodeParamName = "scode" + s;
            String statusParamName = "status" + s;
            String commentParamName = "comment" + s;
            String scode = request.getParameter(scodeParamName);
            String status = request.getParameter(statusParamName);
            String comment = request.getParameter(commentParamName);
            AttendanceDTO attendanceDTO = new AttendanceDTO();
            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setLessonID(lessonId);
            attendanceDTO.setLesson(lessonDTO);
            attendanceDTO.setScode(scode);
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setSid(sid);
            attendanceDTO.setStudent(studentDTO);
            attendanceDTO.setStatus(Integer.parseInt(status));
            attendanceDTO.setComment(comment);
            attendanceDTO.setRecordedDay(DateTimeUtil.getCurrentSqlDate());
            attendanceDTO.setRecordedTime(DateTimeUtil.getCurrentSqlTime());
            teacherService.updateAttendance(attendanceDTO);
        }
        SessionUtil.getInstance().putValue(request, "lessonId", lessonId);
        response.sendRedirect(request.getContextPath() + "/teacher/confirm");
    }


}
