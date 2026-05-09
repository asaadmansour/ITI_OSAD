/*
 * TASK 1: Thread Creation - Four Different Ways
 * 
 * Demonstrates creating and starting threads using:
 * 1. Separate class implementing Runnable interface
 * 2. Extending Thread class
 * 3. Lambda function
 * 4. Method reference
 */

public class One {
    
    // ============================================================
    // HELPER METHOD (Used by Method 4: Method Reference)
    // ============================================================
    
    /**
     * Prints the current thread's name 5 times with 1 second delay
     */
    public static void printThreadName() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    // ============================================================
    // MAIN METHOD
    // ============================================================
    
    public static void main(String[] args) {
        
        System.out.println("=== Starting All 4 Thread Creation Methods ===\n");
        
        // --------------------------------------------------------
        // METHOD 1: Separate Class Implementing Runnable
        // --------------------------------------------------------
        System.out.println("Method 1: Creating thread with Runnable implementation");
        NamePrinterExternalRunnable runnable = new NamePrinterExternalRunnable();
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();
        
        // --------------------------------------------------------
        // METHOD 2: Extending Thread Class
        // --------------------------------------------------------
        System.out.println("Method 2: Creating thread by extending Thread class");
        MyThreadClass extendedThread = new MyThreadClass();
        extendedThread.start();
        
        // --------------------------------------------------------
        // METHOD 3: Lambda Function
        // --------------------------------------------------------
        System.out.println("Method 3: Creating thread with lambda function");
        Thread lambdaThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        lambdaThread.start();
        
        // --------------------------------------------------------
        // METHOD 4: Method Reference
        // --------------------------------------------------------
        System.out.println("Method 4: Creating thread with method reference");
        Thread methodRefThread = new Thread(One::printThreadName);
        methodRefThread.start();
        
        System.out.println("\n=== All threads started! ===\n");
    }
}