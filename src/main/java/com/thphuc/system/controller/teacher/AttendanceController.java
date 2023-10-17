package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.controller.authentication.BasedRequiredAuthenticationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.model.Feature;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class AttendanceController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {

    }
}
