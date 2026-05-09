package com.company.notification;

/**
 * Handles sending SMS notifications via Twilio REST API.
 */
public class SmsSender implements MessagingService<SmsRequest>{
    private String truncateForSms(String message) {
        String oneLine = message.replace("\n", " ").trim();
        if (oneLine.length() > 160) {
            return oneLine.substring(0, 157) + "...";
        }
        return oneLine;
    }
    public void send(SmsRequest message) {
        // Simulate REST call to Twilio
        String truncatedMessage = truncateForSms(message.getMessage());
        System.out.println("[TWILIO] Sending SMS via account " + SMSConfig.getAccountSid());
        System.out.println("[SMS SENT] To: " + message.getToPhoneNumber());
        System.out.println("  Message: " + truncatedMessage);
    }
}
