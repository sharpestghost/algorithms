package com.m.sort;

public class QuickSort implements Sort {

    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length-1);
    }


    public static void quickSort(Comparable[] arr, int left, int right) {
        if (left < right) {
            int splitPoint = partition(arr, left, right);
            //sort the sub array to the left of the current one
            quickSort(arr, left, splitPoint - 1);
            //sort the sub array to the left of the current one
            quickSort(arr, splitPoint + 1, right);
        }
    }

    private static int partition(Comparable[] subarr, int left, int right) {
        Comparable key = subarr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (subarr[j].compareTo(key) < 0) {
                swap(subarr, ++i, j);
            }
        }
        swap(subarr, right, i + 1);
        return (i + 1);
    }

    static void swap(Comparable[] array, int i, int j) {
        Comparable swapState = array[i];
        array[i] = array[j];
        array[j] = swapState;
    }

    static void showArray(Comparable[] arr) {
        for (Comparable value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Comparable[] libraryNum = {124.2, 235.1, 456.4, 123.13, 756.23, 476.4, 28.5, 998.2, 3.79, 1.08};
        System.out.println("Initial array");
        showArray(libraryNum);
        quickSort(libraryNum, 0, libraryNum.length - 1);
        System.out.println("Sorted array");
        showArray(libraryNum);
    }


}
