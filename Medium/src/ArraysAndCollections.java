/**
 * Medium Program 2: Arrays and Collections
 * Description: Demonstrates arrays and ArrayList operations
 * Concepts: Arrays, ArrayList, collections framework, iteration
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysAndCollections {
    public static void main(String[] args) {
        System.out.println("=== Arrays and Collections Example ===");
        
        // 1. Regular Arrays
        System.out.println("\n1. Regular Arrays:");
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // Array operations
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average: " + (sum / (double) numbers.length));
        
        // 2. ArrayList
        System.out.println("\n2. ArrayList:");
        ArrayList<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        System.out.println("Fruits list: " + fruits);
        
        // ArrayList operations
        fruits.add(1, "Grapes"); // Insert at index 1
        System.out.println("After insertion: " + fruits);
        
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
        
        Collections.sort(fruits);
        System.out.println("Sorted fruits: " + fruits);
        
        // 3. ArrayList with Integer
        System.out.println("\n3. ArrayList with Numbers:");
        ArrayList<Integer> scores = new ArrayList<>();
        scores.addAll(Arrays.asList(85, 92, 78, 96, 88, 75, 90));
        System.out.println("Scores: " + scores);
        
        // Find max, min, average
        int maxScore = Collections.max(scores);
        int minScore = Collections.min(scores);
        double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        
        System.out.println("Max score: " + maxScore);
        System.out.println("Min score: " + minScore);
        System.out.println("Average score: " + String.format("%.2f", average));
        
        // 4. 2D Array
        System.out.println("\n4. 2D Array (Matrix):");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Find sum of diagonal elements
        int diagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }
        System.out.println("Diagonal sum: " + diagonalSum);
    }
}