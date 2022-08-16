package com.m.datastrucutres;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{

    private int size;
    private int capacity;
    private Object[] arrayData;
    private static final int BASE_CAPACITY = 16;
    private static final int MIN_CAPACITY = 4;

    ArrayStack() {
        capacity = BASE_CAPACITY;
        arrayData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if (size == capacity) {
            increaseCapacity();
        }
        arrayData[size++] = elem;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T element = (T) arrayData[--size];
        arrayData[size] = null;
        if (size < capacity / 4 && capacity > MIN_CAPACITY) {
            decreaseCapacity();
        }
        return element;
    }

    @Override
    public T peek() {
        return null;
    }

    private void increaseCapacity() {
        capacity *= 2;
        arrayData = Arrays.copyOf(arrayData, capacity);
    }

    private void decreaseCapacity() {
        capacity /= 2;
        arrayData = Arrays.copyOf(arrayData, capacity);
    }
}
