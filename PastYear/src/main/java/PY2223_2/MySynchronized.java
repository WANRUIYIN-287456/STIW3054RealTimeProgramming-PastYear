package PY2223_2;

import org.apache.commons.lang.time.StopWatch;
import java.util.Scanner;



class ThreadForIncrement extends Thread {
    private Counter counter;
    private int x;

    public ThreadForIncrement(Counter counter, int x) {
        this.counter = counter;
        this.x = x;
    }

    @Override
    public void run() {
        counter.increment(x);
    }
}

class ThreadForDecrement extends Thread {
    private Counter counter;
    private int x;

    public ThreadForDecrement(Counter counter, int x) {
        this.counter = counter;
        this.x = x;
    }

    @Override
    public void run() {
        counter.decrement(x);
    }
}

class Counter {
    private int number;

    public Counter(int number) {
        this.number = number;
    }

    public synchronized void increment(int x) {
        number += x;
    }

    public synchronized void decrement(int x) {
        number -= x;
    }

    public int getNumber() {
        return number;
    }
}

public class MySynchronized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input x: ");
        int x = scanner.nextInt();
        scanner.close();

        Counter counter = new Counter(0);

        ThreadForIncrement incrementThread = new ThreadForIncrement(counter, x);
        ThreadForDecrement decrementThread = new ThreadForDecrement(counter, x);

        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        incrementThread.start();

        try {
            incrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        decrementThread.start();

        try {
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopwatch.stop();

        System.out.println("Result: " + counter.getNumber());
        System.out.println("Execution Time: " + stopwatch.getTime() + " milliseconds");
    }
}

