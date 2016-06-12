package ua.gojava.module_03;


public class SimpleSemaphore implements Semaphore {
    private int permits;
    private final int maxPermits = 5;


    @Override
    public synchronized void acquire() throws InterruptedException { //get
        while (this.permits == 0) {
            this.wait();
        }
        this.permits--;
        this.notifyAll();
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits <= 0) {
            throw new IllegalArgumentException("ERROR| Incorrect argument");
        }
        while (this.permits < permits) {
            this.wait();
        }
        this.permits -= permits;
        this.notifyAll();
    }

    @Override
    public synchronized void release() throws InterruptedException {
        while (this.permits == maxPermits) {
            this.wait();
        }
        this.permits++;
        this.notify();
    }

    @Override
    public synchronized void release(int permits) throws InterruptedException {
        while (this.permits >= maxPermits) {
            this.wait();
        }
        this.permits += permits;
        this.notifyAll();

    }

    @Override
    public synchronized int getAvailablePermits() { // change after
        return permits;
    }
}
