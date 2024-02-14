package PY2223_1;

import java.util.concurrent.atomic.AtomicInteger;

/*
22_23_1 Q5
 */
public class Soalan5 {
    static AtomicInteger ai = new AtomicInteger(78);
    public static void check(){
        assert (ai.intValue()%4) == 0;
        System.out.println(ai);
    }

    public static void increment(){
        ai.incrementAndGet();
        System.out.println(ai);
    }

    public static void decrement(){
        ai.decrementAndGet();
        System.out.println(ai);
    }

    public static void compare(){
        ai.compareAndSet(78,700);
        System.out.println(ai);
    }

    public static void main(String[] args) {
        increment();
        increment();
        decrement();
        compare();
        check();
        System.out.println(ai);
    }


}

/*
79
80
79
79
79
79
 */