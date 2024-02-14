package PY2223_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
2022_2023_2 Q6
 */

public class CallableExample {
    private static int sum = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> callable = () ->{
            Thread.sleep(100);
            for(int i=0; i<=3; i++){
                sum += i;
            }
            return Thread.currentThread().getName() + "-" + sum;
        };

        try{
            for (int i = 0; i<8; i++){
                Future<String> future = executor.submit(callable);
                String result = future.get();
                System.out.println(result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}

/*
pool-1-thread-1-6
pool-1-thread-2-12
pool-1-thread-3-18
pool-1-thread-1-24
pool-1-thread-2-30
pool-1-thread-3-36
pool-1-thread-1-42
pool-1-thread-2-48

 */