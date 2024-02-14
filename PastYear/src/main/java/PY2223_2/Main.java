package PY2223_2;
/*
2022_2023_2_B Q2
 */
class MultiplicationTask implements Runnable {
    private int number;

    public MultiplicationTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + number + " * " + i + " = " + (number * i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MultiplicationTask(1), "Thread-0");
        Thread thread2 = new Thread(new MultiplicationTask(2), "Thread-1");
        Thread thread3 = new Thread(new MultiplicationTask(3), "Thread-2");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/*
Thread-0: 1 * 1 = 1
Thread-2: 3 * 1 = 3
Thread-2: 3 * 2 = 6
Thread-2: 3 * 3 = 9
Thread-1: 2 * 1 = 2
Thread-0: 1 * 2 = 2
Thread-0: 1 * 3 = 3
Thread-1: 2 * 2 = 4
Thread-1: 2 * 3 = 6

 */