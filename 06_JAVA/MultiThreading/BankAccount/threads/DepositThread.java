package threads;

import models.BankAccount;

public class DepositThread extends Thread {
    private BankAccount bankAccount;
    private double amount;
    private int iterations;

    // Constructor
    public DepositThread(BankAccount bankAccount, double amount, int iterations) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            bankAccount.deposit(amount);
        }
    }
}