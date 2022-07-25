package com.m.sort;

public class SelectionSort implements SortInterface {

    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (less(array[j], array[min]))
                    min = j;
            exch(array, i, min);
        }
    }

}
