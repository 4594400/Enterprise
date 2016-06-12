package ua.gojava.module_03;


public class Consumer implements Runnable{
    private final int id;
    private final SimpleSemaphore simpleSemaphore;
    private int permits;

    public Consumer(int id, SimpleSemaphore simpleSemaphore) {
        this.id = id;
        this.simpleSemaphore = simpleSemaphore;
    }

    public Consumer(int id, SimpleSemaphore simpleSemaphore, int permits) {
        this.id = id;
        this.simpleSemaphore = simpleSemaphore;
        this.permits = permits;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                if (permits == 0) {
                    simpleSemaphore.acquire();
                    System.out.println(System.currentTimeMillis() + ": " +  " 1 permit is acquired by Thread - " + id);
                } else {
                    simpleSemaphore.acquire(permits);
                    System.out.println(System.currentTimeMillis() + ": " + permits + " permits is acquired by Thread - " + id);
                }
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " is stopped");
                return;

            } catch (IllegalArgumentException a) {
                System.err.println(a.getMessage() + " : " + Thread.currentThread().getName() + " is stopped");
                return;
            }
        }
    }
}
