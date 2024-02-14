package PY1819_2;
/*
18_19_2_B Q2

public class Deadlock {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String[] args) {
        C1 T1 = new C1();
        C2 T2 = new C2();

        T1.start();
        T2.start();

    }
}

Write the C1 and C2 classes to demonstrate the deadlock situation where both threads are blocked forever using synchronized keyword. The example of the output is shown below.

Thread 1: Holding lock 1...
Thread 1: Waiting for lock 2...
Thread 1: Holding lock 1 & 2...
Thread 2: Holding lock 1...
Thread 2: Waiting for lock 2...
Thread 2: Holding lock 1 & 2...

 */

class C1 extends Thread {

    public void run() {
        synchronized (Deadlock.Lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (Deadlock.Lock2) {
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }
}

class C2 extends Thread {
    public void run() {
        synchronized (Deadlock.Lock1) {
            System.out.println("Thread 2: Holding lock 1...");
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 2...");
            synchronized (Deadlock.Lock2) {
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }
}


public class Deadlock {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String[] args) {
        C1 T1 = new C1();
        C2 T2 = new C2();

        T1.start();
        T2.start();

    }
}

/*
Thread 1: Holding lock 1...
Thread 1: Waiting for lock 2...
Thread 1: Holding lock 1 & 2...
Thread 2: Holding lock 1...
Thread 2: Waiting for lock 2...
Thread 2: Holding lock 1 & 2...
 */