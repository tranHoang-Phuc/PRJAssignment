package com.thphuc.system.util;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.InternetAddress;
import java.util.Properties;


public class EmailUtil {
    static final String email = "hoangphuc7bdtd@gmail.com";
    static final String password = "qbjbemkvbvotrpcx";


    public static boolean sendEmail(String toEmail, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP host for Gmail
        properties.put("mail.smtp.port", "587"); // TLS port for Gmail
        properties.put("mail.smtp.auth", "true"); // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };
        Session session = Session.getInstance(properties, authenticator);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(email));
            msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(toEmail, false));
            msg.setSubject(subject);
            msg.setContent(body, "text/html; charset=UTF-8"); // Use "text/html" for HTML content
            jakarta.mail.Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
