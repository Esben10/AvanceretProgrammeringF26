package concurrency.banckaccountdeadlocksolution;

public class SafeTransfer {
    public static void transfer(BankAccount from, BankAccount to, int amount) {
        BankAccount first = from.hashCode() < to.hashCode() ? from : to;
        BankAccount second = from == first ? to : from;

        synchronized (first) {
            synchronized (second) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() +
                            ": Transferred " + amount);
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            ": Not enough funds");
                }
            }
        }
    }
}
