package PY2223_2;

/*
2022_2023_2 Q2
 */

public class Simple extends Thread{
    @Override
    public void run() {
        System.out.println("Simple running...");
    }

    public static void main(String[] args) {
        Simple t1 = new Simple();
        Simple t2 = new Simple();

        System.out.println("Name of t1:" + t1.getName());
        System.out.println("Name of t2:" + t2.getName());
        System.out.println("id of t1:" + t1.getId());

        t2.start();
        t1.start();

        t2.setName("Realtime programming");
        System.out.println("After changing name of t2:" + t2.getName());
    }
}

/*
Name of t1:Thread-0
Name of t2:Thread-1
id of t1:14
After changing name of t2:Realtime programming
Simple running...
Simple running...

 */