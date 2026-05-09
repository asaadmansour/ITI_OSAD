import models.BankAccount;

/**
 * Bank Account Multithreading Demo
 * 
 * Tests race conditions with multiple threads accessing the same account.
 * 
 * To test:
 * - Phase 1 (Race Condition): Remove 'synchronized' from models.BankAccount methods
 * - Phase 2 (Fixed): Keep 'synchronized' in models.BankAccount methods
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Bank Account Simulation ===\n");
        
        BankAccount bankAccount = new BankAccount();
        System.out.println("Initial Balance: $" + bankAccount.getBalance());
        System.out.println("\nStarting 4 threads (2 deposit, 2 withdraw)...\n");
        
        // Create deposit threads
        Thread depositThread1 = new Thread(() -> {
            for(int i = 0; i < 500; i++) {
                bankAccount.deposit(10);
            }
        });
        
        Thread depositThread2 = new Thread(() -> {
            for(int i = 0; i < 500; i++) {
                bankAccount.deposit(10);
            }
        });
        
        // Create withdraw threads
        Thread withdrawThread1 = new Thread(() -> {
            for(int i = 0; i < 200; i++) {
                bankAccount.withdraw(10);
            }
        });
        
        Thread withdrawThread2 = new Thread(() -> {
            for(int i = 0; i < 200; i++) {
                bankAccount.withdraw(10);
            }
        });
        
        // Start all threads
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        // Wait for all threads to finish
        depositThread1.join();
        depositThread2.join();
        withdrawThread1.join();
        withdrawThread2.join();
        
        // Print results
        System.out.println("\n=== Results ===");
        double expectedBalance = 1000.0 + (500 + 500) * 10 - (200 + 200) * 10;
        double actualBalance = bankAccount.getBalance();
        
        System.out.println("Expected Final Balance: $" + expectedBalance);
        System.out.println("Actual Final Balance: $" + actualBalance);
        
        if (Math.abs(actualBalance - expectedBalance) < 0.01) {
            System.out.println("✅ CORRECT! No race condition detected.");
        } else {
            System.out.println("❌ INCORRECT! Race condition detected!");
            System.out.println("Difference: $" + (actualBalance - expectedBalance));
        }
    }
}
