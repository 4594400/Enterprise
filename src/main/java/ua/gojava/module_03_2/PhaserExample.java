package ua.gojava.module_03_2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class PhaserExample implements SquareSum{
    private static final int THREAD_POOL_SIZE = 4;
    Phaser phaser = new Phaser(THREAD_POOL_SIZE);


    public static void main(String[] args) throws Exception {
        //int [] array = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new PhaserExample().getSquareSum(createArray(), THREAD_POOL_SIZE));
    }



    public int runTasks(List<Callable<Integer>> tasks) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        int result = 0;

        for (Future f : futures) {
            result += (int) f.get();
        }
        executorService.shutdown();
        phaser.arriveAndDeregister();
        return result;
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws Exception {
        // array divided into parts for each of the threads
        List<int[]> list = splitArray(values, numberOfThreads);

        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            final int finalI = i;

            tasks.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                        int[] contentFromList = list.get(finalI);
                        for (int k = 0; k < contentFromList.length; k++) {
                            sum += contentFromList[k] * contentFromList[k];
                        }
                    return sum;
                }
            });
        }
        return runTasks(tasks);
    }

    public static ArrayList<int []> splitArray(int[] array, int n){
        ArrayList<int []> chunks = new ArrayList<>();

        if (array == null || array.length == 0 || array.length / n <= 1) {
            return chunks;
        }

        int countElemInChunk;
        if (array.length % n == 0) {
            countElemInChunk = array.length / n;
        } else {
            countElemInChunk = array.length / n + 1;
        }

        for (int i = 0; i < array.length; i += Math.min(array.length - i, countElemInChunk)) {
            int [] chunk =  Arrays.copyOfRange(array, i, Math.min(array.length, i + countElemInChunk));
            chunks.add(chunk);
        }
        return chunks;
    }

    public static int [] createArray() {
        Random random = new Random();
        int [] array = new int[50_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
