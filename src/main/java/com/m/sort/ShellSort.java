package com.m.sort;

public class ShellSort implements Sort {

    /*
    Complexity: worst-case - O(1)
    Perfomance: best - O(n log n), worst - O(n^(3/2))
     */
    @Override
    public void sort(Comparable[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }
        /*
        Shell sort is an improved version of insertion sort algorithm.
        Idea of algorithm is decreasing the number of sorts by comparing
        and sorting far apart elements instead of adjacent ones. This
        implementation uses a sequence gap of 1, 4, 13, 40..., which starts
        with the highest gap the smaller the length of the array,
        and ends with sorting of adjacent elements.
         */
        int step = 1;
        //find the highest gap
        while (step < arr.length / 3) {
            step = 3 * step + 1;
        }
        //sorting the array
        shellSort(arr, step);
    }

    private void shellSort(Comparable[] arr, int step) {
        while (step >= 1) {
            for (int i = step; i < arr.length; i++) {
                //perform compare and swap like in insertion sort
                for (int j = i; j >= step && less(arr[j], arr[j - step]); j -= step)
                    exch(arr, j, j - step);
            }
            //move to next sort iteration
            step = step / 3;
        }
    }

}
