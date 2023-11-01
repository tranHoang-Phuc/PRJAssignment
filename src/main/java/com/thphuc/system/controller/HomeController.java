package com.thphuc.system.controller;

import com.thphuc.system.controller.authentication.BasedRequiredAuthenticationController;
import com.thphuc.system.dto.AccountDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeController extends BasedRequiredAuthenticationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        Map<String, String> featureMappingUrl = new HashMap<>();
        if(user.getRole().getRoleId() == 1) {
            featureMappingUrl.put("Weekly timetable", "weeklySchedule");
            featureMappingUrl.put("Attendance report","teacher/report-attendance");
            featureMappingUrl.put("Instructor Profile","teacher/profile");
            request.setAttribute("featureMappingUrl", featureMappingUrl);
            request.getRequestDispatcher("view/teacher/home.jsp").forward(request, response);
        } else if(user.getRole().getRoleId() == 2) {
            featureMappingUrl.put("Weekly timetable", "weeklySchedule");
            featureMappingUrl.put("Attendance report", "student/report-attendance");
            featureMappingUrl.put("Student Profile","student/profile");
            request.setAttribute("featureMappingUrl", featureMappingUrl);
            request.getRequestDispatcher("view/student/home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {

    }
}
