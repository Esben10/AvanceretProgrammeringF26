package concurrency.deadlockexample;

public class A {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("method1 done");
            }
        }
    }

    public void method2() {
        synchronized (lock1) { // samme rækkefølge!
            synchronized (lock2) {
                System.out.println("method2 done");
            }
        }
    }
}
