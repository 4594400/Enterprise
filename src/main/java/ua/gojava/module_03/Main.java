package ua.gojava.module_03;


public class Main {
    public static void main(String[] args) {
        SimpleSemaphore simpleSemaphore = new SimpleSemaphore();
        new Thread(new Producer(2000, simpleSemaphore)).start();
        new Thread(new Producer(2000, simpleSemaphore, 4)).start();


        new Thread(new Consumer(1, simpleSemaphore)).start();
        new Thread(new Consumer(2, simpleSemaphore, 3)).start();

    }


}
