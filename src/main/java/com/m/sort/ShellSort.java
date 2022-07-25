package com.m.sort;

public class ShellSort implements SortInterface {
    @Override
    public void sort(Comparable[] array) {
        int h = 1;
        int N = array.length;
        while (h < N/3) {
            h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
        }
        while (h >= 1)
        { // h-sort the array.
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h)
                    exch(array, j, j-h);
            }

            h = h/3;
        }
    }

}
