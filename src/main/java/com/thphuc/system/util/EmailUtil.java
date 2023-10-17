package com.thphuc.system.util;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailUtil {
    static final String email = "hoanghuc7bdtd@gmail.com";
    static final String password = "gorrbefjgjgsbthg";

    public static boolean sendEmail(String toEmail, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // smtp host
        properties.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };
        // Tạo mới 1 phiên làm việc
        Session session = Session.getInstance(properties, authenticator);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(email);
            msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(toEmail, false));
            msg.setSubject(subject);
            msg.setContent(body, "text/HTML; charset=UTF-8");
            jakarta.mail.Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EmailUtil.sendEmail("thphuc110523@gmail.com", "Test", "Test");
    }
}
