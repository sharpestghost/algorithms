package com.m.sort;

import java.util.Arrays;

public class IntMergeSort implements IntSortInterface {

    @Override
    public void sort(int[] array) {
        int[] sortedValues = mergeSort(array);
        System.arraycopy(sortedValues, 0, array, 0, array.length);
    }

    private int[] mergeSort(int[] array) {
        int N = array.length;
        if (N <= 1) return array;

        return merge(mergeSort(Arrays.copyOfRange(array, 0, N / 2)), mergeSort(Arrays.copyOfRange(array, N / 2, N)));
    }

    private static int[] merge(int[] leftPart, int[] rightPart) {
        int leftLength = leftPart.length;
        int rightLength = rightPart.length;
        int totalLength = leftLength + rightLength;
        int i1 = 0, i2 = 0;
        int[] tempArray = new int[totalLength];

        for (int i = 0; i < totalLength; i++) {
            if (i1 == leftLength) {
                tempArray[i] = rightPart[i2++];
            } else if (i2 == rightLength) {
                tempArray[i] = leftPart[i1++];
            } else {
                if (leftPart[i1] < rightPart[i2]) {
                    tempArray[i] = leftPart[i1++];
                } else {
                    tempArray[i] = rightPart[i2++];
                }
            }
        }
        return tempArray;
    }

    public static void main(String[] args) {

    }


}
