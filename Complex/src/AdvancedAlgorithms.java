/**
 * Complex Program 3: Advanced Algorithms
 * Description: Implements sorting algorithms, binary search, and recursive solutions
 * Concepts: Algorithms, recursion, time complexity, searching and sorting
 */
import java.util.Arrays;
import java.util.Random;

public class AdvancedAlgorithms {
    
    // Quick Sort Algorithm
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Merge Sort Algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    // Binary Search Algorithm
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Element not found
    }
    
    // Fibonacci using recursion with memoization
    private static long[] fibMemo = new long[100];
    
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        if (fibMemo[n] != 0) {
            return fibMemo[n];
        }
        
        fibMemo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fibMemo[n];
    }
    
    // Tower of Hanoi recursive solution
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        towerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Algorithms Example ===");
        
        // Generate random array for sorting
        Random random = new Random();
        int[] originalArray = new int[10];
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random.nextInt(100);
        }
        
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        
        // Quick Sort Demo
        int[] quickSortArray = originalArray.clone();
        long startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        long quickSortTime = System.nanoTime() - startTime;
        System.out.println("Quick Sort Result: " + Arrays.toString(quickSortArray));
        System.out.println("Quick Sort Time: " + quickSortTime + " nanoseconds");
        
        // Merge Sort Demo
        int[] mergeSortArray = originalArray.clone();
        startTime = System.nanoTime();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        long mergeSortTime = System.nanoTime() - startTime;
        System.out.println("Merge Sort Result: " + Arrays.toString(mergeSortArray));
        System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");
        
        // Binary Search Demo
        int target = quickSortArray[5]; // Pick a random element
        int index = binarySearch(quickSortArray, target);
        System.out.println("\nBinary Search for " + target + ": Found at index " + index);
        
        // Fibonacci Demo
        System.out.println("\nFibonacci Sequence (first 15 numbers):");
        for (int i = 0; i < 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // Tower of Hanoi Demo
        System.out.println("\nTower of Hanoi (3 disks):");
        towerOfHanoi(3, 'A', 'C', 'B');
    }
}