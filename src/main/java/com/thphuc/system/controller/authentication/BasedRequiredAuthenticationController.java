package com.thphuc.system.controller.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.repository.campus.AccountRepository;
import com.thphuc.system.service.authentication.LoginService;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class BasedRequiredAuthenticationController extends HttpServlet {
    private boolean isRequiredAuthenticated(HttpServletRequest request) {
        AccountDTO account = (AccountDTO) SessionUtil.getInstance().getValue(request, "account");
        if (account != null) {
            return true;
        } else {
            String username = null;
            String password = null;
            String campus = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (username != null && password != null && campus != null) {
                        break;
                    }
                    if ("username".equals(cookie.getName())) {
                        username = cookie.getValue();
                    } else if ("password".equals(cookie.getName())) {
                        password = cookie.getValue();
                    }
                    if ("campus".equals(cookie.getName())) {
                        campus = cookie.getValue();
                    }
                }
                if (username != null && password != null && campus != null) {
                    AccountRepository accountRepository = new AccountRepository();
                    LoginService loginService = new LoginService(accountRepository);
                    return loginService.getLogin(username, password, campus) != null;
                }
            }
        }

        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (true) {
            doGet(req, resp, (AccountDTO) SessionUtil.getInstance().getValue(req, "account"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (true) {
            doPost(req, resp, (AccountDTO) SessionUtil.getInstance().getValue(req, "account"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user)
            throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user)
            throws ServletException, IOException;
}
