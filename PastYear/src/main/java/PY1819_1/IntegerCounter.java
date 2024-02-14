package PY1819_1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
18_19_1_B Q3
Write a Java program by implementing Callable<Integer> interface to count the total number of integer N starting from 200. Then display the result using Future<Integer> and ExecutorService interfaces.
 */
public class IntegerCounter implements Callable<Integer> {
    private final int start;

    public IntegerCounter(int start) {
        this.start = start;
    }

    @Override
    public Integer call() {
        int count = 0;
        for (int i = start; i <= Integer.MAX_VALUE; i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> counter = new IntegerCounter(200);
        Future<Integer> future = executor.submit(counter);

        try {
            int totalCount = future.get();
            System.out.println("Total count: " + totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
