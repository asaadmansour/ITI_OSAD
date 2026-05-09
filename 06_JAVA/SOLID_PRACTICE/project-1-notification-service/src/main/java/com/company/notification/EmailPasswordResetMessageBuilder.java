package com.company.notification;

public class EmailPasswordResetMessageBuilder implements MessageBuilder<EmailRequest> {
     @Override
    public EmailRequest build(User user) {
        String subject = "Password Reset Request";
        String body = "Hi " + user.getName() + ",\n\n"
                + "We received a request to reset your password. "
                + "Click here to reset: https://app.company.com/reset?token=abc123\n\n"
                + "If you didn't request this, ignore this message.\n\n"
                + "— The Company Team";
        
        return new EmailRequest(user.getEmail(), subject, body);
    }
}
