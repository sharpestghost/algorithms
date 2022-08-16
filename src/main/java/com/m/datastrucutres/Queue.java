package com.m.datastrucutres;

public interface Queue<T> {

    //return stack size of elements
    int size();

    //return if the stack is empty
    boolean isEmpty();

    //offer the element on the queue
    void offer (T elem);

    //pop out the element
    T pop();

    //peek the element
    T peek();

    //remove element
    T remove();
}
