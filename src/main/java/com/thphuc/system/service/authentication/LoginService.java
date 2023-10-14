package com.thphuc.system.service.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.model.Account;
import com.thphuc.system.repository.campus.AccountRepository;
import com.thphuc.system.repository.campus.IRepository;
import com.thphuc.system.service.campus.CampusService;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService {

    private AccountRepository accountRepository;

    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO getLogin(String username, String password, String campus) {
        Account account = accountRepository.get(username, password, Integer.parseInt(campus));
        if (account != null) {
            AccountDTO accountDTO = convertToDTO(account);
            return accountDTO;
        }
        return null;
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountID(account.getAccountID());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setRole(account.getRole());
        accountDTO.setCampus(account.getCampus());
        return accountDTO;
    }

    public void addToCookie(String username, String password, String campus, HttpServletResponse resp) {
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


}
