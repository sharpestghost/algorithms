package com.m.sort;

public interface Sort {

    void sort(Comparable[] array) ;

    default boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    default void exch(Comparable[] array, int i, int j) {
        Comparable swapState = array[i];
        array[i] = array[j];
        array[j] = swapState;
    }

}
