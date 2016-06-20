package ua.gojava.module_03_2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PhaserExample implements SquareSum{
    private static final int THREAD_POOL_SIZE = 3;


    public static void main(String[] args) throws Exception {
        int [] array = new int[] {1,2,3};
       new PhaserExample().getSquareSum(array, THREAD_POOL_SIZE);
    }

    private static void runTasks(List<Callable<Integer>> tasks) throws Exception {
        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<Integer>> futures = new ArrayList<>();
        for (Callable<Integer> task : tasks) {
            phaser.register();
            System.out.println("Before task.call");
            //task.call();
            Thread.sleep(100);
            futures.add(executorService.submit(task));
        }


        for (Future f : futures) {
            System.out.println("Before f.get");
            System.out.println(f.get());
            Thread.sleep(1000);
        }
        executorService.shutdown();
        phaser.arriveAndDeregister();

    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws Exception {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Into Task 1");
                return 1;
            }
        });

        tasks.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Into Task 2");
                return 2;
            }
        });
        tasks.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Into Task 3");
                return 3;
            }
        });
        runTasks(tasks);

        return 0;
    }
}
