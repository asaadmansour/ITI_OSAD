package com.company.notification;

import java.util.HashMap;
import java.util.Map;

public class ChannelFactory {

    private final Map<String, Channel> channels = new HashMap<>();

    public ChannelFactory() {
        channels.put("email", new EmailChannel());
        channels.put("sms",   new SmsChannel());
    }

    public Channel getFor(String channelName) {
        Channel channel = channels.get(channelName);
        if (channel == null) throw new IllegalArgumentException("Unknown channel: " + channelName);
        return channel;
    }
}
