package ru.alekseiadamov.lesson3;

import ru.alekseiadamov.lesson3.core.Queue;

public class QueueImpl<E> implements Queue<E> {
    protected final E[] queue;
    protected int head;
    protected int tail;
    protected int maxSize;
    protected int size;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;
        queue = (E[]) new Object[maxSize];
        head = 0;
        tail = -1;
        size = 0;
    }

    @Override
    public void insert(E e) {
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = e;
        size++;
    }

    @Override
    public E remove() {
        if (head == maxSize) {
            head = 0;
        }
        E temp = queue[head++];
        size--;
        return temp;
    }

    @Override
    public E peek() {
        return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int size() {
        return size;
    }
}
