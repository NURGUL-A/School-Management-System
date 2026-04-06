package kz.enu.School.Management.System.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final String fromAddress;

    public EmailService(
            JavaMailSender mailSender,
            @Value("${app.mail.from:${spring.mail.username:}}") String fromAddress
    ) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress == null ? "" : fromAddress.trim();
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        if (!fromAddress.isBlank()) {
            message.setFrom(fromAddress);
        }
        mailSender.send(message);
    }
}
