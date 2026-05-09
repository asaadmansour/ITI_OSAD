package com.company.notification;

public class SmsPasswordResetMessageBuilder implements MessageBuilder<SmsRequest> {
    @Override
    public SmsRequest build(User user) {
        String message = "Hi " + user.getName() + "! A password reset was requested for your account. Visit https://app.company.com/reset to proceed. Ignore if this wasn't you.";
        return new SmsRequest(user.getPhoneNumber(), message);
    }
}
