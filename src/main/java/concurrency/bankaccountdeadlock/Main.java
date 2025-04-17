package concurrency.bankaccountdeadlock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();

        Thread t1 = new Thread(new TransferRunnable(acc1, acc2, 100));
        Thread t2 = new Thread(new TransferRunnable(acc2, acc1, 200));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance acc1: " + acc1.getBalance());
        System.out.println("Final balance acc2: " + acc2.getBalance());
    }
}
