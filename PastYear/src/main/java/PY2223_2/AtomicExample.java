package PY2223_2;


import java.util.concurrent.atomic.AtomicInteger;

/*
2022_2023_2 Q5
 */

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Runnable task = () -> {
            for(int i = 0; i<1000; i++){
                counter.incrementAndGet();
            }
        };

        System.out.println("Counter Value1: " + counter.get());
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        try{
            System.out.println("Counter Value2: " + counter.get());
            thread1.join();
            System.out.println("Counter Value3: " + counter.get());
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final Counter Value: " + counter.get());
    }
}

/*
Counter Value1: 0
Counter Value2: 0
Counter Value3: 2000
Final Counter Value: 2000

Process finished with exit code 0

 */