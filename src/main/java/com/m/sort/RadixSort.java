package com.m.sort;

public class RadixSort {
    static int findMax(int[] arr) {
        int maxItem = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > maxItem)
                maxItem = arr[i];
        return maxItem;
    }

    static void countingSort(int[] arr, int place) {
        int size = arr.length;
        int[] output = new int[size + 1];
        int maxItem = findMax(arr);

        int[] count = new int[maxItem + 1];
        for (int i = 0; i < maxItem; ++i)
            count[i] = 0;

        // Determine count of elements
        for (int i = 0; i < size; i++)
            count[(arr[i] / place) % 10]++;

        // Determine cummulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in the correct place
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++)
            arr[i] = output[i];
    }

    // Main function to implement radix sort
    static void radixSort(int[] arr) {
        int max = findMax(arr);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, place);
    }

    static void showArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] libraryNum = {124, 235, 456, 123, 756, 476, 285, 998, 379, 108};
        System.out.println("Initial array");
        showArray(libraryNum);
        radixSort(libraryNum);
        System.out.println("Sorted array");
        showArray(libraryNum);
    }
}
