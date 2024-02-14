package PY2223_2;
/*
2022_2023_2 Q4
Write a java program to create three threads for performing multiplication calculations. The program should implement the Runnable interface and define a Main class with parameterized constructor. Each thread should multiply a given number with values from 1 to 3 and display the result below.
        Thread-0: 1 * 1 = 1
        Thread-2: 3 * 1 = 3
        Thread-2: 3 * 2 = 6
        Thread-2: 3 * 3 = 9
        Thread-1: 2 * 1 = 2
        Thread-1: 2 * 2 = 4
        Thread-1: 2 * 3 = 6
        Thread-0: 1 * 2 = 2
        Thread-0: 1 * 3 = 3
 */

public class CheckProcessor {
    public static void main(String[] args) {
        int x = Runtime.getRuntime().availableProcessors();
        long y = Runtime.getRuntime().freeMemory();
        long z = Runtime.getRuntime().totalMemory();
    }
}
