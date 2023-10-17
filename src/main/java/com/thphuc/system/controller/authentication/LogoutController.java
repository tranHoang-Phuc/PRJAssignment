package com.thphuc.system.controller.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogoutController extends BasedRequiredAuthenticationController{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        SessionUtil.getInstance().destroy(request);
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {

    }
}
