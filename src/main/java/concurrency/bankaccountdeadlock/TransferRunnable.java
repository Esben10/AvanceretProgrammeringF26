package concurrency.bankaccountdeadlock;

public class TransferRunnable implements Runnable {
    private final BankAccount from;
    private final BankAccount to;
    private final int amount;

    public TransferRunnable(BankAccount from, BankAccount to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (from) {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (to) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println("Transfer succeeded");
                }
            }
        }
    }
}
