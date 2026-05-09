package Three;
/*
 * TASK 3: Race Condition Demonstration
 * 
 * Requirements:
 * 1. Create a class that implements Runnable interface
 * 
 * 2. Declare two counters:
 *    - counter1 (primitive int)
 *    - counter2 (primitive int)
 * 
 * 3. Thread behavior:
 *    - Compare the state of the two counters
 *    - Print the result of comparison to console
 *    - Increment counter1
 *    - Sleep for 10 milliseconds
 *    - Increment counter2
 * 
 * 4. Execution:
 *    - Create multiple similar threads (all doing the same thing)
 *    - Run the program
 *    - Interrupt after 3 seconds of execution
 * 
 * 5. Comparison:
 *    - Compare console output with SYNCHRONIZED critical sections
 *    - Compare console output with NON-SYNCHRONIZED critical sections
 *    - Observe the race condition!
 */

public class Three {
    
    // ============================================================
    // RUNNABLE CLASS: Counter (Non-Synchronized Version)
    // ============================================================
public static void main(String[] args) throws InterruptedException {
    // Create ONE task (shared by all threads)
    myClass task = new myClass();
    
    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);
     Thread thread3 = new Thread(task);
    
    System.out.println("=== Starting 3 threads ===\n");
    
    thread1.start();
    thread2.start();
    thread3.start();
    
    Thread.sleep(3000);
    
    thread1.interrupt();
    thread2.interrupt();
    thread3.interrupt();
    
    System.out.println("\n=== Stopped after 3 seconds ===");
}
    
    // ============================================================
    // MAIN METHOD
    // ============================================================
    
}
