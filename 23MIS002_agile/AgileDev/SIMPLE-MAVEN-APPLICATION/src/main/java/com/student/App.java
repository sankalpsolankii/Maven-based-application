import java.util.Scanner;

public class AttendanceSystem {

    static class Student {
        String name;
        double classesAttended;
        double totalClasses;

        Student(String name, double attended, double total) {
            this.name = name;
            this.classesAttended = attended;
            this.totalClasses = total;
        }

        // Feature 1: Attendance % Calculation
        public double calculatePercentage() {
            if (totalClasses == 0)
                return 0.0;
            return (classesAttended / totalClasses) * 100;
        }

        // Feature 2 & 3: Eligibility and Warning Status
        public void displayStatus() {
            double percentage = calculatePercentage();

            System.out.println("\n--- Attendance Report for " + name + " ---");
            System.out.printf("Attendance Percentage: %.2f%%\n", percentage);

            if (percentage >= 75.0) {
                System.out.println("Exam Eligibility: ELIGIBLE");
                System.out.println("Status: On Track");
            } else if (percentage >= 65.0) {
                System.out.println("Exam Eligibility: NOT ELIGIBLE");
                System.out.println("Status: WARNING - Attendance is low. Improve soon!");
            } else {
                System.out.println("Exam Eligibility: NOT ELIGIBLE");
                System.out.println("Status: CRITICAL - High risk of academic penalty.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Total Number of Classes: ");
        double total = scanner.nextDouble();

        System.out.print("Enter Number of Classes Attended: ");
        double attended = scanner.nextDouble();

        if (attended > total) {
            System.out.println("Error: Attended classes cannot exceed total classes.");
        } else {
            Student student = new Student(name, attended, total);
            student.displayStatus();
        }

        scanner.close();
    }
}
