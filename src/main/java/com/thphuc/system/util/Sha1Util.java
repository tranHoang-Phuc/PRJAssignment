/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author tran Hoang Phuc
 */
public class Sha1Util {

    public static String toSHA1(String password) {
        String salt = "oasmstu423#nf49@nf;.c";
        String result = null;
        try {
            String saltedPassword = password + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(saltedPassword.getBytes("UTF-8"));
            byte[] hashBytes = md.digest();
            result = Base64.getEncoder().encodeToString(hashBytes);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
