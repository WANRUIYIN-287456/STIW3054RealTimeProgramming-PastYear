package PY1819_1;
/*
18_19_1 Q8
 */

import java.sql.SQLOutput;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Exam implements Runnable{
    private final int id;
    private static final Lock lock = new ReentrantLock();

    Exam(int id){
        this.id = id;
        lock.lock();
        id++;
        lock.unlock();
    }

    public void run(){
        System.out.println(id + " Read Pdf Files");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread ID: " + id + " finished ...");
        try{
            System.out.println("Calculate words ...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class MyLock {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("The process failed ...");
            }
        });

        for(int i = 0; i < 3; i++){
            executorService.execute(new PY1819_1.Exam(i+1));
        }

        System.out.println("Start again ...");
        executorService.shutdown();

    }
}

/*
Start again ...
2 Read Pdf Files
1 Read Pdf Files
3 Read Pdf Files
Thread ID: 3 finished ...
Calculate words ...
Thread ID: 2 finished ...
Calculate words ...
Thread ID: 1 finished ...
Calculate words ...
 */