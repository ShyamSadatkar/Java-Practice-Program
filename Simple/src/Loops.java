/**
 * Simple Program 5: Loops
 * Description: Demonstrates for, while, and do-while loops
 * Concepts: for loop, while loop, do-while loop, break, continue
 */
public class Loops {
    public static void main(String[] args) {
        System.out.println("=== Loop Examples ===");
        
        // For loop example
        System.out.println("\n1. For Loop - Numbers 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // While loop example
        System.out.println("\n2. While Loop - Even numbers 2 to 10:");
        int num = 2;
        while (num <= 10) {
            System.out.print(num + " ");
            num += 2;
        }
        System.out.println();
        
        // Do-while loop example
        System.out.println("\n3. Do-While Loop - Countdown from 5:");
        int count = 5;
        do {
            System.out.print(count + " ");
            count--;
        } while (count > 0);
        System.out.println("Go!");
        
        // Nested loops - multiplication table
        System.out.println("\n4. Nested Loops - 3x3 Multiplication Table:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
        
        // Loop with break and continue
        System.out.println("\n5. Loop with Break and Continue:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // Skip 5
            }
            if (i == 8) {
                break; // Stop at 8
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}