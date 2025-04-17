package concurrency.synchronization;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger();

        Runnable task1 = () -> logger.log("Hej");

        new Thread(task1).start();
        new Thread(task1).start();

        SmartLogger smartLogger = new SmartLogger();

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                logger.log(Thread.currentThread().getName() + ": " + i);
            }
        };

        Thread t1 = new Thread(task2, "T1");
        Thread t2 = new Thread(task2, "T2");

        t1.start();
        t2.start();



    }
}
