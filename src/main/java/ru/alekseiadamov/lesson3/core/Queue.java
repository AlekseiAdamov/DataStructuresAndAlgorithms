package ru.alekseiadamov.lesson3.core;

public interface Queue<E> {

    void insert(E e);

    E remove();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();

}
