package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.InstructorDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.InstructorRepository;
import com.thphuc.system.repository.campus.StudentRepository;
import com.thphuc.system.service.student.StudentService;
import com.thphuc.system.service.teacher.TeacherService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class ProfileController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        InstructorRepository instructorRepository = new InstructorRepository();
        TeacherService teacherService = new TeacherService(instructorRepository);
        int accountId = user.getAccountID();
        InstructorDTO instructor = teacherService.getInstructorByAccountId(accountId);
        request.setAttribute("instructor", instructor);
        request.getRequestDispatcher("../view/teacher/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {

    }
}
