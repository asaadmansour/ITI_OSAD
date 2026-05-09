package com.company.notification;

import java.util.HashMap;
import java.util.Map;

public class SmsChannel implements Channel {

    private final Map<String, MessageBuilder<SmsRequest>> builders = new HashMap<>();
    private final SmsSender sender = new SmsSender();

    public SmsChannel() {
        builders.put("password_reset", new SmsPasswordResetMessageBuilder());
        builders.put("promotion",      new SmsPromotionMessageBuilder());
    }

    @Override
    public void deliver(User user, String notificationType) {
        MessageBuilder<SmsRequest> builder = builders.get(notificationType);
        if (builder == null) throw new IllegalArgumentException("No SMS builder for: " + notificationType);
        SmsRequest request = builder.build(user);
        sender.send(request);
    }
}
