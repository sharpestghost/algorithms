package com.m.sort;

public class InsertionSort implements Sort {

    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        /*
        Insertion sort selects each element of the array from second to last
        and compares it with the previous elements until it finds
        the previous element that is smaller than the selected one.
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]) ; j--) {
                exch(arr, j, j - 1);
            }
        }
    }




}
