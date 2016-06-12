package ua.gojava.module_03;


public class Producer implements Runnable{
    private final int period;
    private final SimpleSemaphore simpleSemaphore;
    private int permits;

    public Producer(int period, SimpleSemaphore simpleSemaphore) {
        this.period = period;
        this.simpleSemaphore = simpleSemaphore;
        this.permits = 0;
    }

    public Producer(int period, SimpleSemaphore simpleSemaphore, int permits) {
        this.period = period;
        this.simpleSemaphore = simpleSemaphore;
        this.permits = permits;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (permits == 0) {
                    simpleSemaphore.release();
                    System.out.println(System.currentTimeMillis() + ": "  + " 1 permit is released");
                } else {
                    simpleSemaphore.release(permits);
                    System.out.println(System.currentTimeMillis() + ": "  + permits + " permits is released");
                }
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " is stopped");
                return;
            }
        }

    }
}
