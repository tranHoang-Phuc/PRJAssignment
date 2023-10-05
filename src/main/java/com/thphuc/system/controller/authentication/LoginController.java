/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.controller.authentication;

import com.thphuc.system.dto.CampusDTO;
import com.thphuc.system.repository.campus.CampusRepository;
import com.thphuc.system.repository.campus.ICampusRepository;
import com.thphuc.system.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class LoginController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICampusRepository repository = new CampusRepository();
        LoginService service = new LoginService(repository);
        List<CampusDTO> list = service.getAllCampus();
        req.setAttribute("list", list);
        req.getRequestDispatcher("view/authentication/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int cid = Integer.parseInt(req.getParameter("campus"));
        if (cid == 0) {
            ICampusRepository repository = new CampusRepository();
            LoginService service = new LoginService(repository);
            List<CampusDTO> list = service.getAllCampus();
            req.setAttribute("list", list);
            req.setAttribute("message", "Please choose a campus");
            req.getRequestDispatcher("view/authentication/login.jsp").forward(req, resp);
        } else {

        }
    }
}
