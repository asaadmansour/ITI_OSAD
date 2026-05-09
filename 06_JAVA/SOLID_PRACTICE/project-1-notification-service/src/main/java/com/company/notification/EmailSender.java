package com.company.notification;

import java.util.Date;

/**
 * Handles sending email notifications via SMTP.
 * Only instantiate this when you actually need to send an email.
 */
public class EmailSender implements MessagingService<EmailRequest> {

    @Override
    public void send(EmailRequest message) {
        String toAddress = message.getToAddress();
        String subject = message.getSubject();
        String body = message.getBody();
        // Simulate SMTP connection and send
        System.out.println("[SMTP] Connecting to " + EmailConfig.getSmtpHost() + ":" + EmailConfig.getSmtpPort());
        System.out.println("[SMTP] Authenticating as " + EmailConfig.getSmtpUser());
        System.out.println("[EMAIL SENT] To: " + toAddress);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body: " + body);
    }
}
