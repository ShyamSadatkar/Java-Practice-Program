/**
 * Simple Program 4: Conditional Statements
 * Description: Demonstrates if-else statements and comparison operators
 * Concepts: if-else, else if, comparison operators, logical operators
 */
import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Grade Calculator ===");
        System.out.print("Enter your score (0-100): ");
        int score = scanner.nextInt();
        
        // Determine grade using if-else statements
        char grade;
        String message;
        
        if (score >= 90) {
            grade = 'A';
            message = "Excellent!";
        } else if (score >= 80) {
            grade = 'B';
            message = "Good job!";
        } else if (score >= 70) {
            grade = 'C';
            message = "Fair work.";
        } else if (score >= 60) {
            grade = 'D';
            message = "Needs improvement.";
        } else {
            grade = 'F';
            message = "Please study more.";
        }
        
        // Display result
        System.out.println("\n=== Result ===");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Message: " + message);
        
        // Check if passing
        if (score >= 60) {
            System.out.println("Status: PASS");
        } else {
            System.out.println("Status: FAIL");
        }
        
        scanner.close();
    }
}