package com.m.sort;

import java.util.Arrays;

public class MergeSort implements Sort {

    public void sort(Comparable[] array) {
        /*
        Mergesort is a divide-and-conquer sorting algorithm. The algorithm
        implementation consists of 2 parts: consecutively splitting the array
        in half until it's divided into N arrays of 1 element each, then merging
        the arrays by passing to the new array the smallest element from the two
        subarrays until both subarrays are empty (in case if elements remain in
        only one subarray they are all passed to the new array).
        The merge is performed until the original length of the array is obtained.
         */
        Comparable[] sortedValues = MergeSort.mergeSort(array);
        System.arraycopy(sortedValues, 0, array, 0, array.length);
    }


    static Comparable[] mergeSort(Comparable[] arr) {
        int N = arr.length;
        if (N <= 1) return arr;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, N / 2)),
                mergeSort(Arrays.copyOfRange(arr, N / 2, N)));
    }

    private static Comparable[] merge(Comparable[] leftPart, Comparable[] rightPart) {
        int leftLength = leftPart.length;
        int rightLength = rightPart.length;
        int totalLength = leftLength + rightLength;
        int i1 = 0, i2 = 0;
        Comparable[] tempArray = new Comparable[totalLength];
        //compare last element in left part to first in right
        for (int i = 0; i < totalLength; i++) {
            if (i1 == leftLength) {
                tempArray[i] = rightPart[i2++];
            } else if (i2 == rightLength) {
                tempArray[i] = leftPart[i1++];
            } else {
                if (leftPart[i1].compareTo(rightPart[i2]) < 0) {
                    tempArray[i] = leftPart[i1++];
                } else {
                    tempArray[i] = rightPart[i2++];
                }
            }
        }
        return tempArray;
    }



    public static void main(String[] args) {

        Comparable[] array = new Comparable[4];
        for (int i=0; i<array.length; i++) {
            array[i] = Math.random() * 14 - 7.0;
        }
        long start = System.nanoTime();
// ... perform operations ...

        array = MergeSort.mergeSort(array);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        long time = System.nanoTime() - start;
        System.out.println("Operation took " + time + " ns");
        System.out.println(java.util.Arrays.toString(array));
    }
}
