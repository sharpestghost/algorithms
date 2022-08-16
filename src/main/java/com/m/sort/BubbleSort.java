package com.m.sort;

public class BubbleSort {


    public void sort(Comparable[] array) {
        bubbleSort(array);
    }

    public static void bubbleSort(Comparable arr[]) {
        /*
        Bubble sort selects each element of the array from second to last
        and compares it with the previous elements until it finds
        the previous element that is smaller than the selected one.
         */
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            int n = arr.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    needIteration = swap(arr, j);
        }
    }

    static boolean swap(Comparable[] arr, int j) {
        if (arr[j].compareTo(arr[j + 1]) > 0) {
            Comparable temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            return true;
        }
        return false;
    }


    static void showArray(Comparable[] arr) {
        for (Comparable value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        long init = System.nanoTime();
        Comparable[] libraryNum = {2.35, 45.6, 12.3, 756.0, 47.6, 285.5, 99.8, 37.9, 1.08, 4.3, 6.4, 8.2, 4.5, 2.35, 45.6, 12.3, 756.0, 47.6, 285.5, 99.8, 37.9, 1.08, 4.3, 6.4, 8.2, 4.5};
        System.out.println("Initial array");
        showArray(libraryNum);
        bubbleSort(libraryNum);
        System.out.println("Sorted array");
        showArray(libraryNum);
        System.out.println((System.nanoTime() - init) / 1_000_000.0 + " ms");
    }


}