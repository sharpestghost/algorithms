package com.m.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort implements SortInterface{

    @Override
    public void sort(Comparable[] array) {
        Comparable[] sortedValues = MergeSort.mergeSort(array);
        System.arraycopy(sortedValues, 0, array, 0, array.length);
    }

    static Comparable[] mergeSort(Comparable[] array) {
        int N = array.length;
        if (N <= 1) return array;

        return merge(mergeSort(Arrays.copyOfRange(array, 0, N / 2)), mergeSort(Arrays.copyOfRange(array, N / 2, N)));
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

    public static void arraySum() {
        int[][] data = {
                { 1, 2, 3 },
                {22},
                {13, 11},
                { 4, 5, 6 }
        };
        int max = 0;
        for (int[] arr: data) {
            int next = findSum(arr);
            if (next > max) max = next;
        }

        System.out.println(max );
    }
    private static int findSum(int[] arr) {
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        arraySum();

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
