package ru.alekseiadamov.lesson3;

import ru.alekseiadamov.lesson3.core.Deque;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insertRight(E e) {
        super.insert(e);
    }

    @Override
    public E removeRight() {
        if (tail == -1) {
            tail = maxSize - 1;
        }
        size--;
        return queue[tail--];
    }

    @Override
    public void insertLeft(E e) {
        if (head == 0) {
            head = maxSize;
        }
        queue[--head] = e;
        size++;
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }
}
