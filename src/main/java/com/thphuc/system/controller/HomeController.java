package com.thphuc.system.controller;

import com.thphuc.system.controller.authentication.BasedRequiredAuthenticationController;
import com.thphuc.system.dto.AccountDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HomeController extends BasedRequiredAuthenticationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {

    }
}
