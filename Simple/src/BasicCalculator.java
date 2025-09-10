/**
 * Simple Program 3: Basic Calculator
 * Description: Performs basic arithmetic operations
 * Concepts: arithmetic operators, variables, user input
 */
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Basic Calculator ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        // Perform calculations
        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;
        
        // Display results
        System.out.println("\n=== Results ===");
        System.out.println(num1 + " + " + num2 + " = " + addition);
        System.out.println(num1 + " - " + num2 + " = " + subtraction);
        System.out.println(num1 + " * " + num2 + " = " + multiplication);
        
        if (num2 != 0) {
            System.out.println(num1 + " / " + num2 + " = " + division);
        } else {
            System.out.println("Division by zero is not allowed!");
        }
        
        scanner.close();
    }
}