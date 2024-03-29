package PY1819_2;
/*
18_19_2 Q2
 */
class Testing implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " is running ...");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + " is running ..."); //Thread[main,5,main] is running ...
        Thread t1 = new Thread(new Testing(), "stiw3054");
        Thread t2 = new Thread(new Testing());

        t2.start(); //Thread-0 is running ...
        t1.start(); //stiw3054 is running ...

        System.out.println(Thread.currentThread().getName() + " is running ..."); //main is running ...

        t1.run(); //main is running ...
        t2.run(); // main is running ...

        System.out.println(t2.getName() + " is stopping ..."); //Thread-0 is stopping ...
    }
}
/*
Thread[main,5,main] is running ...
main is running ...
main is running ...
main is running ...
Thread-0 is stopping ...
Thread-0 is running ...
stiw3054 is running ...
 */
