package concurrency.bankaccount;

public class BankRunnable implements Runnable {
    private final BankAccount account;
    private final boolean deposit;
    private final int amount;

    public BankRunnable(BankAccount account, boolean deposit, int amount) {
        this.account = account;
        this.deposit = deposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
