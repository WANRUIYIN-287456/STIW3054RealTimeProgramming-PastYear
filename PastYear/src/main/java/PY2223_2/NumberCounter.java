package PY2223_2;

/*
2022_2023_2_B Q1
Write a java program using threads to count numbers from 1 to 10500.
Pause for 5 seconds between each number and display a message for every 50 numbers.
Provide code for a NumberCounter class extending Thread to handle counting and
messaging. Then write the main method to start the thread.

 */
class NumberCounter extends Thread {
    @Override
    public void run() {
        System.out.println("Counting starts.");
        for (int i = 1; i <= 10500; i++) {
            System.out.println("Count: " + i);
            // Display message for every 50 numbers
            if (i % 50 == 0) {
                System.out.println("Reached " + i + " numbers.");
            }
            try {
                // Pause for 5 seconds between each number
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberCounter counter = new NumberCounter();
        counter.start();
    }
}




