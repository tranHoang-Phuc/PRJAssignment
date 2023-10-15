package com.thphuc.system.controller.schedule;

import com.thphuc.system.controller.authentication.BasedRequiredAuthenticationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.UserDTO;
import com.thphuc.system.repository.campus.InstructorRepository;
import com.thphuc.system.repository.campus.StudentRepository;
import com.thphuc.system.service.authentication.AccountService;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ScheduleController extends BasedRequiredAuthenticationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        InstructorRepository instructorRepository = new InstructorRepository();
        StudentRepository studentRepository = new StudentRepository();
        AccountService accountService = new AccountService(studentRepository, instructorRepository);
        UserDTO userDTO = accountService.getUserByAccountID(user);
        SessionUtil.getInstance().putValue(request, "user", userDTO);
        if (user.getRole().getRoleId() == 1) {
            request.getRequestDispatcher("view/teacher/schedule.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("view/student/schedule.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {

    }
}
