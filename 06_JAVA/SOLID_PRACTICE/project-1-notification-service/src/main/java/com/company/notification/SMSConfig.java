package com.company.notification;

public class SMSConfig {
    public static String getAccountSid()  { return System.getenv("TWILIO_ACCOUNT_SID"); }
    public static String getAuthToken()   { return System.getenv("TWILIO_AUTH_TOKEN"); }
    public static String getFromNumber()  { return System.getenv("TWILIO_FROM_NUMBER"); }
}
