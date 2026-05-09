package com.company.notification;

import java.util.HashMap;
import java.util.Map;

public class EmailChannel implements Channel {

    private final Map<String, MessageBuilder<EmailRequest>> builders = new HashMap<>();
    private final EmailSender sender = new EmailSender();

    public EmailChannel() {
        builders.put("password_reset", new EmailPasswordResetMessageBuilder());
        builders.put("promotion",      new EmailPromotionMessageBuilder());
    }

    @Override
    public void deliver(User user, String notificationType) {
        MessageBuilder<EmailRequest> builder = builders.get(notificationType);
        if (builder == null) throw new IllegalArgumentException("No email builder for: " + notificationType);
        EmailRequest request = builder.build(user);
        sender.send(request);
    }
}
