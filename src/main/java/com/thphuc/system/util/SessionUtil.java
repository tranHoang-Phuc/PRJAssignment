/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.util;

import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author tran Hoang Phuc
 */
public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    
    public static SessionUtil getInstance() {
        if (sessionUtil != null) {
            sessionUtil = new SessionUtil();
        } 
        return sessionUtil;
    }
    
    public void putValue(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }
    
    public Object getValue(HttpServletRequest req, String key) {
        return req.getSession().getAttribute(key);
    }
    
    public void removeValue(HttpServletRequest req, String key) {
        req.getSession().removeAttribute(key);
    }
    
    public void detroy(HttpServletRequest req) {
        req.getSession().invalidate();
    }
}
