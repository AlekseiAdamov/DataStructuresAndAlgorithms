package ru.alekseiadamov.lesson3.core;

public interface Deque<E> {

    void insertRight(E e);

    E removeRight();

    void insertLeft(E e);

    E removeLeft();
}
