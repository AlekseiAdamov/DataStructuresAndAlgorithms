package ru.alekseiadamov.lesson3.core;

public interface Stack<E> {

    void push(E value);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
