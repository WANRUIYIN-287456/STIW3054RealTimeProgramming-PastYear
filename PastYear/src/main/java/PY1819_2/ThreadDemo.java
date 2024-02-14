package PY1819_2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/*
18_19_2_B Q3
Write a Java program to execute 3 threads. Each of the thread will display 10 sequence numbers from 1 to 10. After all the threads have been treminated, then the program will sum 10 sequence numbers from 1 to 10. You MUST use CyclicBarrier and implement Runnable interface to solve this problem.
 */
public class ThreadDemo implements Runnable {
    private static final int NUM_THREADS = 3;
    private static final int NUM_COUNTS = 10;

    private static int[][] threadOutputs = new int[NUM_THREADS][NUM_COUNTS];
    private static int[] sums = new int[NUM_THREADS];

    private final int threadId;
    private final CyclicBarrier barrier;

    public ThreadDemo(int threadId, CyclicBarrier barrier) {
        this.threadId = threadId;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NUM_COUNTS; i++) {
                threadOutputs[threadId][i] = i + 1;
                System.out.println("Thread " + threadId + ": " + (i + 1));
            }
            barrier.await(); // Wait for all threads to reach this point
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // Calculate sum of sequence numbers for this thread
        int sum = 0;
        for (int i = 0; i < NUM_COUNTS; i++) {
            sum += threadOutputs[threadId][i];
        }
        sums[threadId] = sum;
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            // All threads have reached barrier, calculate total sum
            int totalSum = 0;
            for (int i = 0; i < NUM_THREADS; i++) {
                totalSum += sums[i];
            }
            System.out.println("Total sum of sequence numbers: " + totalSum);
        });

        for (int i = 0; i < NUM_THREADS; i++) {
            ThreadDemo threadDemo = new ThreadDemo(i, barrier);
            new Thread(threadDemo).start();
        }
    }
}

/*
Thread 0: 1
Thread 0: 2
Thread 0: 3
Thread 0: 4
Thread 0: 5
Thread 0: 6
Thread 0: 7
Thread 0: 8
Thread 0: 9
Thread 0: 10
Thread 2: 1
Thread 1: 1
Thread 2: 2
Thread 1: 2
Thread 1: 3
Thread 1: 4
Thread 1: 5
Thread 1: 6
Thread 1: 7
Thread 1: 8
Thread 1: 9
Thread 1: 10
Thread 2: 3
Thread 2: 4
Thread 2: 5
Thread 2: 6
Thread 2: 7
Thread 2: 8
Thread 2: 9
Thread 2: 10
Total sum of sequence numbers: 0
 */

