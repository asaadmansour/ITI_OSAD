package Two;
/*
 * TASK 2: Spam Thread with User Interruption
 * 
 * Requirements:
 * 1. Create a nested class 'Spam' that receives:
 *    - An array of time intervals (in milliseconds)
 *    - An array of messages (same length as intervals)
 * 
 * 2. Spam behavior:
 *    - Print a message from the array
 *    - Sleep for the corresponding time interval
 *    - Repeat for all messages
 * 
 * 3. Interruption:
 *    - Stop execution when 'Enter' key is pressed
 *    - Can be simulated by passing '\n' to input stream
 * 
 * 4. Demo:
 *    - Simulate Enter key press after 5 seconds
 */

public class Two {
    
    // ============================================================
    // NESTED CLASS: Spam
    // ============================================================
    
    static class Spam implements Runnable {
        private int[] intervals;
        private String[] messages;
        
        Spam(int[] intervals, String[] messages) {
            this.intervals = intervals;
            this.messages = messages;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < intervals.length; i++) {
                // Check if thread was interrupted
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("\nSpam stopped due to interruption!");
                    return;
                }
                
                try {
                    System.out.println(messages[i]);
                    Thread.sleep(intervals[i]);
                } catch (InterruptedException e) {
                    System.out.println("\nSpam interrupted during sleep!");
                    return;  // Exit when interrupted
                }
            }
            System.out.println("\nAll messages sent!");
        }
    }
    
    // ============================================================
    // MAIN METHOD
    // ============================================================
    
    public static void main(String[] args) {
        int[] intervals = {1500, 2000, 1500, 3000, 1000};
        String[] messages = {"Msg 1", "Msg 2", "Msg 3", "Msg 4", "Msg 5"};
        
        System.out.println("=== Starting Spam Thread ===\n");
        
        // Create ONE Spam object
        Spam spam = new Spam(intervals, messages);
        Thread spamThread = new Thread(spam);
        spamThread.start();
        
        try {
            // Simulate Enter key press after 5 seconds
            Thread.sleep(5000);
            spamThread.interrupt();
            System.out.println("\n=== Enter key simulated - thread interrupted! ===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
