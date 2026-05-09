package com.company.notification;

public interface MessageBuilder<T extends NotificationRequest> {
    T build(User user);
}
