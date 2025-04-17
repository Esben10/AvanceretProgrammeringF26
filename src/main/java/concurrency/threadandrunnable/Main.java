package concurrency.threadandrunnable;

public class Main {

    public static void main(String[] args) {

        Thread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}
