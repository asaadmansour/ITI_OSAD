package com.company.notification;

public class EmailRequest implements NotificationRequest {
    private String toAddress;     
    private String subject;       
    private String body;       
    public EmailRequest(String toAddress,String subject,String body) {
        this.toAddress = toAddress;
        this.body = body;
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public String getSubject() {
        return subject;
    }
    public String getToAddress() {
        return toAddress;
    }
}
