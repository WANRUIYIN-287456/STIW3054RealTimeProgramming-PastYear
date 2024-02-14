package PY1920_1;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
/*
19_20_1_B Q1
Write a program using java.util.concurrent.TimeUnit and java.util.Calendar to calculate the number of minutes between 31 January 2015 and 12 August 2019.
*/
public class MinutesCalculator {
    public static void main(String[] args) {
        // Create Calendar instances for the start and end dates
        Calendar startDate = Calendar.getInstance();
        startDate.set(2015, Calendar.JANUARY, 31);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, Calendar.AUGUST, 12);

        // Calculate the difference in milliseconds between the two dates
        long differenceInMillis = endDate.getTimeInMillis() - startDate.getTimeInMillis();

        // Convert milliseconds to minutes
        long minutesDifference = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis);

        // Output the result
        System.out.println("Number of minutes between 31 January 2015 and 12 August 2019: " + minutesDifference + " minutes.");
    }
}

/*
Number of minutes between 31 January 2015 and 12 August 2019: 2381760 minutes.
 */

