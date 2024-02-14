package PY1920_1;

/*
19_20_1_B Q3
You are required to develop a simple concurrent application using 4 threads that will produce 3 random numbers between 0 and 200 for each thread.  (Hints: use ThreadLocalRandom class)                                                                                                                                                                          Sample output:
        Thread-0: 124
        Thread-3: 75
        Thread-1: 114
        Thread-1: 49
        Thread-1: 99
        Thread-2: 30
        Thread-3: 59
        Thread-0: 146
        Thread-3: 35
        Thread-2: 197
        Thread-0: 166
        Thread-2: 56

 */
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new RandomNumberThread();
            thread.start();
        }
    }

    static class RandomNumberThread extends Thread {
        @Override
        public void run() {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < 3; i++) {
                int randomNumber = random.nextInt(201); // Generates a random number between 0 and 200
                System.out.println(Thread.currentThread().getName() + ": " + randomNumber);
            }
        }
    }
}

/*
Thread-2: 182
Thread-2: 67
Thread-2: 186
Thread-3: 22
Thread-3: 104
Thread-3: 38
Thread-0: 47
Thread-0: 9
Thread-0: 33
Thread-1: 50
Thread-1: 60
Thread-1: 122

 */