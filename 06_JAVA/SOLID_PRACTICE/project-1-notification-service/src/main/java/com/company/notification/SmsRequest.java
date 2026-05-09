package com.company.notification;

public class SmsRequest implements NotificationRequest {
    private String toPhoneNumber;  
    private String message;   
    public SmsRequest(String toPhoneNumber,String message) {
        this.toPhoneNumber = toPhoneNumber;
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public String getToPhoneNumber() {
        return toPhoneNumber;
    }
}
