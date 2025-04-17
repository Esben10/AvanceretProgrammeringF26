package concurrency.bankaccount;

import java.util.Random;

public class BankAccount {
    private int balance = 0;

    public synchronized void  deposit(int amount) {
        int temp = balance;
        sleep(); // kunstig forsinkelse
        balance = temp + amount;
    }

    public synchronized void withdraw(int amount) {
        int temp = balance;
        sleep();
        balance = temp - amount;
    }

    public int getBalance() {
        return balance;
    }

    private void sleep() {
        try {
            Thread.sleep(10 + new Random().nextInt(50));
        } catch (InterruptedException e) {
            System.out.println("Tråden vågnede");
        }
    }
}
