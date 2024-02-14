package PY1920_1;

import java.util.concurrent.*;

public class Question4 {
    public static void main(String[] args)  {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay( () -> {
            System.out.println("STIW3054");
            //return null;
        }, 0, 1, TimeUnit.MINUTES);

        Future<?> result = service.submit(() ->
                System.out.println("Realtime"));
try{
    System.out.println(result.get());
}catch(InterruptedException | ExecutionException e){
    e.printStackTrace();
        }
    }
}
