package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.StudentRepository;
import com.thphuc.system.service.student.StudentService;
import com.thphuc.system.util.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class EmailController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentDTO s = studentService.get(Integer.parseInt(sid));
        request.setAttribute("student", s);
        request.getRequestDispatcher("../view/teacher/remind.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        EmailUtil.sendEmail(email, subject, content);
        response.sendRedirect(request.getContextPath() + "/weeklySchedule");
    }
}
