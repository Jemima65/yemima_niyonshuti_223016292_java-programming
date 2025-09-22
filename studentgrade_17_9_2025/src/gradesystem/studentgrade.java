package gradesystem;

import java.util.Scanner;

public class studentgrade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int totalStudents = 0;
        int passes = 0;
        int fails = 0;

        System.out.println("Enter student marks (0-100). Enter 0 to stop.");

        // read first mark
        int mark = sc.nextInt();

      
        while (mark != 0) {
            // validate marks between 0 and 100
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark! Please enter a value between 0 and 100.");
            } else {
                totalStudents++;

                // assign grade
                if (mark >= 80) {
                    System.out.println("Grade: A");
                    passes++;
                } else if (mark >= 70) {
                    System.out.println("Grade: B");
                    passes++;
                } else if (mark >= 60) {
                    System.out.println("Grade: C");
                    passes++;
                } else if (mark >= 50) {
                    System.out.println("Grade: D");
                    passes++;
                } else {
                    System.out.println("Grade: F");
                    fails++;
                }
            }

            // ask again for next mark
            System.out.print("Enter next mark (0 to stop): ");
            mark = sc.nextInt();
        }

        // summary report
        System.out.println("\nSummary Report");
        System.out.println("==================");
        System.out.println("Total students: " + totalStudents);
        System.out.println("Passed: " + passes);
        System.out.println("Failed: " + fails);

        if (totalStudents > 0) {
            double passRate = (passes * 100.0) / totalStudents;
            System.out.println("Class Pass Rate: " + passRate + "%");
        } else {
            System.out.println("No student records entered.");
        }

        sc.close();
    }
}