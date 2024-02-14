package PY1920_1;
/*
19_20_1_B Q4 OBJECT CLASS
Write a java program to find a maximum number of 5000 random numbers in an array using parallel execution. You are required to solve the probelm using 2 classes, by implementing ForkJoin framework and extending RecursiveTask<Long>. The number of thread must depend on the number of available processors in your computer.

 */
import java.util.concurrent.RecursiveTask;

public class MaxNumberTask extends RecursiveTask<Long> {
    private int[] numbers;
    private int start;
    private int end;

    public MaxNumberTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // If the range is small, directly calculate the maximum
        if (end - start <= 100) {
            long max = Long.MIN_VALUE;
            for (int i = start; i < end; i++) {
                max = Math.max(max, numbers[i]);
            }
            return max;
        }

        // If the range is large, split it into smaller tasks
        int mid = (start + end) / 2;
        MaxNumberTask leftTask = new MaxNumberTask(numbers, start, mid);
        MaxNumberTask rightTask = new MaxNumberTask(numbers, mid, end);

        // Fork the tasks
        leftTask.fork();
        rightTask.fork();

        // Join the results
        long leftResult = leftTask.join();
        long rightResult = rightTask.join();

        // Return the maximum of the two results
        return Math.max(leftResult, rightResult);
    }
}
