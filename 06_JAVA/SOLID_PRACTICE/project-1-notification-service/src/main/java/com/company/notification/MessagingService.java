package com.company.notification;

public interface MessagingService<T extends NotificationRequest> {
    void send(T message);
}
