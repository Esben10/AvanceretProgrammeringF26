package concurrency.banckaccountdeadlocksolution;

public class BankAccount {
    private int balance = 1000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
