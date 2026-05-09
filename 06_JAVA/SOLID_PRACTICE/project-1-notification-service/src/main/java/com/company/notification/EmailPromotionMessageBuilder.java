package com.company.notification;

public class EmailPromotionMessageBuilder implements MessageBuilder<EmailRequest> {
    public EmailRequest build(User user) {
String subject = "Exclusive Offer Just for You!";
        String body = "Hi " + user.getName() + ",\n\n"
                + "Don't miss out on our seasonal sale — up to 40% off selected items!\n"
                + "Shop now: https://app.company.com/sale\n\n"
                + "— Marketing Team";
        return new EmailRequest(user.getEmail(),subject,body);
    }
}

