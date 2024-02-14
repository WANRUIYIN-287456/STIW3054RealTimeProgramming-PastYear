package PY2223_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
22_23_1 Q6
 */
public class Soalan6 implements Callable <String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService test = Executors.newFixedThreadPool(8);
        List<Future<String>> list = new ArrayList<>();
        Callable <String> callable = new Soalan6();

        for (int i = 0; i < 3; i++){
            Future<String> future = test.submit(callable);
            list.add(future);
        }

        for (Future<String> future : list){
            try{
                System.out.println(future.get());
                System.out.println("--> Callable 1");
                System.out.println("--> Callable 2");
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

        test.shutdown();
        System.out.println("End Test");

    }
}

/*
pool-1-thread-1
--> Callable 1
--> Callable 2
pool-1-thread-2
--> Callable 1
--> Callable 2
pool-1-thread-3
--> Callable 1
--> Callable 2
End Test
 */