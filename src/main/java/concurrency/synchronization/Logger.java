package concurrency.synchronization;

public class Logger {
    public synchronized void log(String message) {
        System.out.print("[");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        System.out.print(message);
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        System.out.println("]");
    }
}

