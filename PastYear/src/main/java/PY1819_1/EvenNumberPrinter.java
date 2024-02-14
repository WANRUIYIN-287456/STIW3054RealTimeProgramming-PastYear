package PY1819_1;
/*
18_19_1_B Q1
Write a Java program by extending Thread to display all even numbers between 100  to 120, every two seconds.
 */
public class EvenNumberPrinter extends Thread {
    public void run() {
        for (int i = 100; i <= 120; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EvenNumberPrinter thread = new EvenNumberPrinter();
        thread.start();
    }
}
