package models;

public class BankAccount {
    private double balance = 1000.0;  // Start with $1000
    
    //  public synchronized void deposit(double amount) {
    //      double newBalance = balance + amount;
    //      balance = newBalance;
    //      System.out.println("[" + Thread.currentThread().getName() + "] Deposited $" + amount + ", Balance: $" + balance);
    //  }
    
    //  public synchronized void withdraw(double amount) {
    //      double newBalance = balance - amount;
    //      balance = newBalance;
    //      System.out.println("[" + Thread.currentThread().getName() + "] Withdrew $" + amount + ", Balance: $" + balance);
    //  }
   public  void deposit(double amount) {
       double newBalance = balance + amount;
       balance = newBalance;
       System.out.println("[" + Thread.currentThread().getName() + "] Deposited $" + amount + ", Balance: $" + balance);
   }

   public  void withdraw(double amount) {
       double newBalance = balance - amount;
       balance = newBalance;
       System.out.println("[" + Thread.currentThread().getName() + "] Withdrew $" + amount + ", Balance: $" + balance);
   }
    public double getBalance() {
        return balance;
    }
}