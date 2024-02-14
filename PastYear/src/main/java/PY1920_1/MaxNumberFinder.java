package PY1920_1;
/*
19_20_1_B Q4 MAIN CLASS
Write a java program to find a maximum number of 5000 random numbers in an array using parallel execution. You are required to solve the probelm using 2 classes, by implementing ForkJoin framework and extending RecursiveTask<Long>. The number of thread must depend on the number of available processors in your computer.

 */
import java.util.concurrent.ForkJoinPool;

public class MaxNumberFinder {
    public static void main(String[] args) {
        // Generate an array of 5000 random numbers
        int[] numbers = new int[5000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }

        // Create a ForkJoinPool with the number of available processors
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        // Create an instance of MaxNumberTask and invoke it
        MaxNumberTask task = new MaxNumberTask(numbers, 0, numbers.length);
        long maxNumber = pool.invoke(task);

        // Print the maximum number found
        System.out.println("Maximum number: " + maxNumber);
    }
}

/*
Maximum number: 9996
 */