/**
 * Complex Program 1: Multithreading
 * Description: Demonstrates thread creation, synchronization, and concurrent execution
 * Concepts: Thread class, Runnable interface, synchronization, thread safety
 */

// Producer class that extends Thread
class Producer extends Thread {
    private SharedBuffer buffer;
    private int producerId;
    
    public Producer(SharedBuffer buffer, int producerId) {
        this.buffer = buffer;
        this.producerId = producerId;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.produce(producerId * 10 + i);
                Thread.sleep(1000); // Simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer class that implements Runnable
class Consumer implements Runnable {
    private SharedBuffer buffer;
    private int consumerId;
    
    public Consumer(SharedBuffer buffer, int consumerId) {
        this.buffer = buffer;
        this.consumerId = consumerId;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                buffer.consume(consumerId);
                Thread.sleep(1500); // Simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Shared buffer with synchronization
class SharedBuffer {
    private int buffer;
    private boolean hasData = false;
    
    public synchronized void produce(int data) throws InterruptedException {
        while (hasData) {
            wait(); // Wait if buffer is full
        }
        buffer = data;
        hasData = true;
        System.out.println("Produced: " + data + " by " + Thread.currentThread().getName());
        notifyAll(); // Notify waiting consumers
    }
    
    public synchronized int consume(int consumerId) throws InterruptedException {
        while (!hasData) {
            wait(); // Wait if buffer is empty
        }
        int data = buffer;
        hasData = false;
        System.out.println("Consumed: " + data + " by Consumer-" + consumerId);
        notifyAll(); // Notify waiting producers
        return data;
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        System.out.println("=== Multithreading Example ===");
        
        SharedBuffer buffer = new SharedBuffer();
        
        // Create producer threads
        Producer producer1 = new Producer(buffer, 1);
        Producer producer2 = new Producer(buffer, 2);
        producer1.setName("Producer-1");
        producer2.setName("Producer-2");
        
        // Create consumer threads
        Thread consumer1 = new Thread(new Consumer(buffer, 1));
        Thread consumer2 = new Thread(new Consumer(buffer, 2));
        consumer1.setName("Consumer-1");
        consumer2.setName("Consumer-2");
        
        // Start threads
        System.out.println("Starting threads...");
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        
        try {
            // Wait for all threads to complete
            producer1.join();
            producer2.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All threads completed!");
    }
}