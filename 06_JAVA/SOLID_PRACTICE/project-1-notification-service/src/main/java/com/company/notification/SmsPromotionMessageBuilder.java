package com.company.notification;

public class SmsPromotionMessageBuilder implements MessageBuilder<SmsRequest> {
    @Override
    public SmsRequest build(User user) {
        String message = "Hi " + user.getName() + "! Exclusive deal: up to 40% off selected items TODAY only. Shop now: https://app.company.com/sale - Marketing Team";
        return new SmsRequest(user.getPhoneNumber(), message);
    }
}
