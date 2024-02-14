package PY1819_1;
/*
18_19_1_B Q2
You are required to develop a simple concurrent application using 3 threads that will produce 4 random numbers between 0 and 1500 for each thread.  (Hints: use ThreadLocalRandom class)

 */
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator extends Thread {
    public void run() {
        for (int i = 0; i < 4; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(0, 1501); // Generates random number between 0 and 1500
            System.out.println(Thread.currentThread().getName() + ": " + randomNumber);
        }
    }

    public static void main(String[] args) {
        RandomNumberGenerator thread1 = new RandomNumberGenerator();
        RandomNumberGenerator thread2 = new RandomNumberGenerator();
        RandomNumberGenerator thread3 = new RandomNumberGenerator();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
