package com.company.notification;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
        private static final String LOG_FILE = "notification_audit.log";
        private static final DateTimeFormatter TIMESTAMP_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        public  void logToFile(String userEmail, String notificationType) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FMT);
        String logEntry = timestamp + " | SENT | " + notificationType + " | " + userEmail + "\n";

        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(logEntry);
            System.out.println("[AUDIT LOG] Entry written: " + logEntry.trim());
        } catch (IOException e) {
            System.err.println("[AUDIT LOG] Failed to write log: " + e.getMessage());
        }
    }
}
