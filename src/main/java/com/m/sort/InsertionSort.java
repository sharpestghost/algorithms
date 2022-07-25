package com.m.sort;

public class InsertionSort implements SortInterface{

    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = i; j > 0; j--)
                if (less(array[j], array[j-1]))
                    exch(array, j, j-1);
                else break;
    }
}
