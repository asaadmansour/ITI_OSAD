package com.company.notification;

/**
 * Dispatches notifications to users.
 * Has zero knowledge of channels, message formats, or senders.
 * Adding a new channel or notification type requires no changes here.
 */
public class NotificationManager {

    private final ChannelFactory channelFactory;
    private final Logger         logger;

    public NotificationManager(ChannelFactory channelFactory, Logger logger) {
        this.channelFactory = channelFactory;
        this.logger         = logger;
    }

    public void notify(User user, String notificationType) {
        channelFactory.getFor(user.getPreferredChannel())
                      .deliver(user, notificationType);
        logger.logToFile(user.getEmail(), notificationType);
    }
}
