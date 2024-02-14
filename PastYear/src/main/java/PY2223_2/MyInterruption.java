package PY2223_2;

/*
2022_2023_2_B Q3
Write a Java program that utilises multithreading and thread interruption. The program should create a custom MyInterruption class that extends Thread. The run method of My Interruption class should continuously print the message "STIW3054 RT Programming" until it is interrupted.

 */
class MyInterruption extends Thread {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("STIW3054 RT Programming");
                Thread.sleep(1000); // Pause for 1 second
            }
        } catch (InterruptedException e) {
            // Re-interrupt the thread
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {
        MyInterruption interruptionThread = new MyInterruption();
        interruptionThread.start();

        // Interrupt the thread after 5 seconds
        try {
            Thread.sleep(5000);
            interruptionThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
