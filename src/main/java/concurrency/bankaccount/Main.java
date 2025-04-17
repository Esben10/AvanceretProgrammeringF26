package concurrency.bankaccount;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new BankRunnable(account, true, 100)); // indsæt
            threads[i + 5] = new Thread(new BankRunnable(account, false, 100)); // hæv
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
