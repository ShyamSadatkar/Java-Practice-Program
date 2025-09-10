/**
 * Medium Program 3: File Handling
 * Description: Demonstrates file reading, writing, and handling
 * Concepts: FileWriter, FileReader, BufferedReader, exception handling
 */
import java.io.*;
import java.util.Scanner;

public class FileHandling {
    private static final String FILE_NAME = "student_data.txt";
    
    public static void main(String[] args) {
        System.out.println("=== File Handling Example ===");
        
        // Write data to file
        writeToFile();
        
        // Read data from file
        readFromFile();
        
        // Append data to file
        appendToFile();
        
        // Read updated file
        System.out.println("\nAfter appending:");
        readFromFile();
        
        // Clean up - delete the file
        deleteFile();
    }
    
    // Method to write data to file
    public static void writeToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("Student Records\n");
            writer.write("================\n");
            writer.write("1. John Doe - Computer Science - GPA: 3.8\n");
            writer.write("2. Jane Smith - Mathematics - GPA: 3.9\n");
            writer.write("3. Bob Johnson - Physics - GPA: 3.6\n");
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    // Method to read data from file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\nReading from file:");
            System.out.println("===================");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Method to append data to file
    public static void appendToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write("4. Alice Brown - Chemistry - GPA: 3.7\n");
            writer.write("5. Charlie Davis - Biology - GPA: 3.5\n");
            System.out.println("Data appended to file successfully!");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
    
    // Method to delete file
    public static void deleteFile() {
        File file = new File(FILE_NAME);
        if (file.delete()) {
            System.out.println("\nFile deleted successfully!");
        } else {
            System.out.println("\nFailed to delete file!");
        }
    }
}