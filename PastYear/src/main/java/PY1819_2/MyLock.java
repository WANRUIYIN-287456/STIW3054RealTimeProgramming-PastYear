package PY1819_2;
/*
18_19_2 Q6
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
        System.out.println(id + " starts the Maven ...");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread ID: " + id + " finished ...");
        try{
            System.out.println("After running the Maven ...");
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
                System.out.println("The execution failed ...");
            }
        });

        for(int i = 0; i < 3; i++){
            executorService.execute(new Exam(i+1));
        }

        System.out.println("The execution succeed ...");
        executorService.shutdown();

    }
}

/*
The execution succeed ...
2 starts the Maven ...
3 starts the Maven ...
1 starts the Maven ...
Thread ID: 1 finished ...
Thread ID: 2 finished ...
After running the Maven ...
Thread ID: 3 finished ...
After running the Maven ...
After running the Maven ...

 */