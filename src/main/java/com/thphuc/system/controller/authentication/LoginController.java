/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.controller.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.CampusDTO;
import com.thphuc.system.repository.campus.AccountRepository;
import com.thphuc.system.repository.campus.CampusRepository;
import com.thphuc.system.repository.campus.IRepository;
import com.thphuc.system.service.authentication.LoginService;
import com.thphuc.system.service.campus.CampusService;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author tran Hoang Phuc
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CampusRepository repository = new CampusRepository();
        CampusService campusService = new CampusService(repository);
        List<CampusDTO> list = campusService.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("view/authentication/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String campus = req.getParameter("campus").trim();
        String remember = req.getParameter("remember");
        LoginService loginService = new LoginService(new AccountRepository());
        AccountDTO accountDTO = loginService.getLogin(username, password, campus);
        if (accountDTO != null) {
            SessionUtil.getInstance().putValue(req, "account", accountDTO);
            if (remember != null) {
                Cookie cookieUsername = new Cookie("username", username);
                Cookie cookiePassword = new Cookie("password", password);
                Cookie cookieCampus = new Cookie("campus", campus);
                cookieUsername.setMaxAge(60 * 60 * 24);
                cookiePassword.setMaxAge(60 * 60 * 24);
                cookieCampus.setMaxAge(60 * 60 * 24);
                resp.addCookie(cookieUsername);
                resp.addCookie(cookiePassword);
                resp.addCookie(cookieCampus);
            }
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("message", "Username or password is incorrect");
            req.getRequestDispatcher("view/authentication/login.jsp").forward(req, resp);
        }
    }
}
