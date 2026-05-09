package com.company.notification;

public interface Channel {
    void deliver(User user, String notificationType);
}
