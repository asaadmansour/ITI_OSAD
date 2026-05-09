package com.company.notification;

public class EmailConfig {
    public static String getSmtpHost()     { return System.getenv("SMTP_HOST"); }
    public static int    getSmtpPort()     { return Integer.parseInt(System.getenv("SMTP_PORT")); }
    public static String getSmtpUser()     { return System.getenv("SMTP_USER"); }
    public static String getSmtpPassword() { return System.getenv("SMTP_PASSWORD"); }
}
