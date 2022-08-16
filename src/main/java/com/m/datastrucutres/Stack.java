package com.m.datastrucutres;

public interface Stack<T> {

    //return stack size of elements
    int size();

    //return if the stack is empty
    boolean isEmpty();

    //push the element on the stack
    void push (T elem);

    //pop out the element
    T pop();

    //peek the element
    T peek();
}
