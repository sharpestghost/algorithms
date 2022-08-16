package com.m.sort;

public class SelectionSort implements Sort {

    /*
    Complexity: worst-case - O(1)
    Perfomance: best - O(n^2), avg - O(n^2), worst - O(n^2)
     */
    //TODO: adsfda
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        /*
        Selection sort finds the minimum value of the array and swaps that element with the first.
        hen this action is repeated with the elements of the array from second to last,
        then from third to last, until the array is sorted.
        */
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            exch(arr, i, min);
        }
    }

}
