/**
 * Medium Program 1: Class and Objects (OOP Basics)
 * Description: Demonstrates basic Object-Oriented Programming concepts
 * Concepts: Classes, objects, constructors, methods, encapsulation
 */
public class Student {
    // Private instance variables (encapsulation)
    private String name;
    private int age;
    private String course;
    private double gpa;
    
    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.course = "Not Assigned";
        this.gpa = 0.0;
    }
    
    // Parameterized constructor
    public Student(String name, int age, String course, double gpa) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
    }
    
    // Getter methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public double getGpa() { return gpa; }
    
    // Setter methods
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    
    // Method to display student information
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
        System.out.println("Status: " + getStatus());
    }
    
    // Method to determine academic status
    public String getStatus() {
        if (gpa >= 3.5) {
            return "Excellent";
        } else if (gpa >= 3.0) {
            return "Good";
        } else if (gpa >= 2.0) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }
    
    // Main method to test the class
    public static void main(String[] args) {
        // Create objects using different constructors
        Student student1 = new Student();
        Student student2 = new Student("Alice Johnson", 20, "Computer Science", 3.8);
        
        System.out.println("=== Object-Oriented Programming Example ===");
        
        // Display default student
        System.out.println("\nDefault Student:");
        student1.displayInfo();
        
        // Display parameterized student
        System.out.println("\nParameterized Student:");
        student2.displayInfo();
        
        // Modify student1 using setter methods
        student1.setName("Bob Smith");
        student1.setAge(19);
        student1.setCourse("Mathematics");
        student1.setGpa(3.2);
        
        System.out.println("\nModified Student:");
        student1.displayInfo();
    }
}