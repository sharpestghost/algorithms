package com.m.datastrucutres;

import java.util.Arrays;
import java.util.EmptyStackException;

public class IntStack implements Stack<Integer>{

    private int size;
    private int capacity;
    private int[] arrayData;
    private static final int BASE_CAPACITY = 16;
    private static final int MIN_CAPACITY = 4;
    private int position = 0;

    private IntStack(int maxSize) {
        arrayData = new int[maxSize];
    }
    private IntStack() {
        arrayData = new int[BASE_CAPACITY];
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public void push(Integer value) {
        arrayData[position++] = value;
    }

    @Override
    public Integer pop() {
        return arrayData[--position];
    }

    @Override
    public Integer peek() {
        return arrayData[position - 1];
    }

    private void increaseCapacity() {
        capacity *= 2;
        arrayData = Arrays.copyOf(arrayData, capacity);
    }

    private void decreaseCapacity() {
        capacity /= 2;
        arrayData = Arrays.copyOf(arrayData, capacity);
    }

    // BenchMark IntStack vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        IntStack intStack = new IntStack(n);

        // IntStack times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intStack.push(i);
        for (int i = 0; i < n; i++) intStack.pop();
        long end = System.nanoTime();
        System.out.println("IntStack Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        //    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        //    java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.push(i);
        for (int i = 0; i < n; i++) arrayDeque.pop();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);

        Stack<Integer> listStack = new ListStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) listStack.push(i);
        for (int i = 0; i < n; i++) listStack.pop();
        end = System.nanoTime();
        System.out.println("ListStack Time: " + (end - start) / 1e9);

        Stack<Integer> arrayStack = new ArrayStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayStack.push(i);
        for (int i = 0; i < n; i++) arrayStack.pop();
        end = System.nanoTime();
        System.out.println("ArrayStack Time: " + (end - start) / 1e9);
    }
}
