package classattendance;

import java.util.Scanner;

public class attendance {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // total number of students
        System.out.print("Enter total number of students in class: ");
        int totalStudents = sc.nextInt();

        // max 15 days of attendance
        int[] attendance = new int[15];
        int dairly = 0;

        String choice = null;

        // Do-while loop for daily 
        do {
            if (dairly >= 15) {
                System.out.println("Maximum of 15 days reached.");
                break;
            }

            System.out.print("\nEnter number of students present on Day " + (dairly + 1) + ": ");
            int present = sc.nextInt();

            // validation
            if (present < 0 || present > totalStudents) {
                System.out.println("Invalid number! Must be between 0 and " + totalStudents);
                continue; // skip this day entry
            }

            attendance[dairly] = present;
            dairly++;

            System.out.print("Do you want to enter attendance for another day? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        // 3. Data analysis
        if (dairly == 0) {
            System.out.println("\nNo attendance data recorded.");
            return ;
        }

        // calculate average
        int totalAttendance = 0;
        int lowDays = 0;
        for (int i = 0; i < dairly; i++) {
            totalAttendance += attendance[i];
            if (attendance[i] < (totalStudents / 2.0)) {
                lowDays++;
            }
        }

        double average = (double) totalAttendance / dairly;
        double lowPercentage = (lowDays * 100.0) / dairly;

        // 4. Print results
        System.out.println("\n Attendance Summary ");
        System.out.println("Day\tNumber Present");
        for (int i = 0; i < dairly; i++) {
            System.out.println((i + 1) + "\t" + attendance[i]);
        }

        System.out.println("\nAverage Attendance: " + average);
        System.out.println("Days with <50% attendance: " + lowDays);
        System.out.println("Percentage of low-attendance days: " + lowPercentage + "%");

        sc.close();
    }
}
