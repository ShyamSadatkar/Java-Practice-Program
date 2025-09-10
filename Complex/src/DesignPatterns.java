/**
 * Complex Program 2: Design Patterns - Singleton and Factory
 * Description: Demonstrates Singleton and Factory design patterns
 * Concepts: Design patterns, thread-safe singleton, factory method pattern
 */

// Singleton Pattern - Database Connection
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connectionString;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        connectionString = "jdbc:mysql://localhost:3306/testdb";
        System.out.println("Database connection created!");
    }
    
    // Thread-safe singleton implementation
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("Connected to: " + connectionString);
    }
    
    public void disconnect() {
        System.out.println("Disconnected from database");
    }
}

// Factory Pattern - Shape Factory
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public abstract void draw();
    public abstract double getArea();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + color + " circle with radius: " + radius);
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + color + " rectangle " + width + "x" + height);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base, height;
    
    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + color + " triangle with base: " + base + ", height: " + height);
    }
    
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

class ShapeFactory {
    public static Shape createShape(String shapeType, String color, double... dimensions) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle(color, dimensions[0]);
            case "rectangle":
                return new Rectangle(color, dimensions[0], dimensions[1]);
            case "triangle":
                return new Triangle(color, dimensions[0], dimensions[1]);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

public class DesignPatterns {
    public static void main(String[] args) {
        System.out.println("=== Design Patterns Example ===");
        
        // Singleton Pattern Demo
        System.out.println("\n1. Singleton Pattern:");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("Same instance? " + (db1 == db2));
        db1.connect();
        db2.disconnect();
        
        // Factory Pattern Demo
        System.out.println("\n2. Factory Pattern:");
        try {
            Shape circle = ShapeFactory.createShape("circle", "Red", 5.0);
            Shape rectangle = ShapeFactory.createShape("rectangle", "Blue", 4.0, 6.0);
            Shape triangle = ShapeFactory.createShape("triangle", "Green", 3.0, 4.0);
            
            Shape[] shapes = {circle, rectangle, triangle};
            
            for (Shape shape : shapes) {
                shape.draw();
                System.out.println("Area: " + String.format("%.2f", shape.getArea()));
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}