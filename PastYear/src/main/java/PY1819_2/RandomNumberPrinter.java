package PY1819_2;

import java.util.Random;
/*
18_19_2_B Q1
Write a Java program by implementing the Runnable interface to display 10 random numbers between 100 and 1000. Each result must be displayed every 1 second.
 */
public class RandomNumberPrinter implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = 100 + random.nextInt(901); // Generates random number between 100 and 1000
            System.out.println(randomNumber);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RandomNumberPrinter randomNumberPrinter = new RandomNumberPrinter();
        Thread thread = new Thread(randomNumberPrinter);
        thread.start();
    }
}
