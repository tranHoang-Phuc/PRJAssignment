package com.thphuc.system.controller.viewattendance;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.model.Group;
import com.thphuc.system.repository.campus.StudentRepository;
import com.thphuc.system.service.student.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class ViewAttendanceController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String group = request.getParameter("group");
        String course = request.getParameter("course");
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentDTO studentDTO = studentService.getStudentBySid(Integer.parseInt(sid));
        request.setAttribute("student", studentDTO);
        request.setAttribute("group", group);
        request.setAttribute("course", course);
        request.getRequestDispatcher("../view/student/view-attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {

    }
}
