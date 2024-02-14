package PY1819_2;
/*
18_19_2 Q5
 */

class MyThread extends Thread{
    @Override
    public void run (){
        int count = 0;
        while (!Thread.interrupted()){
            System.out.println("STIW3054 RT Programming");
        }
        System.out.println("Stopped Running ....");
    }

}

public class E1_StopThread {
    public static void main(String[] args) {
        System.out.println("Start ...");
        MyThread thread = new MyThread();
        thread.start();

        try{
            System.out.println("Try STIW3054 ....");
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
