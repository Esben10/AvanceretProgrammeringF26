package concurrency.synchronization;

public class SmartLogger {
    public void log(String message) {
        System.out.print("["); // ikke kritisk
        synchronized (this) {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            System.out.print(message); // kritisk sektion
        }
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        System.out.println("]"); // ikke kritisk
    }
}
