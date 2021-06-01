package ru.alekseiadamov.lesson3;

import ru.alekseiadamov.lesson3.core.Stack;

public class StackImpl<E> implements Stack<E> {
    private final int maxSize;
    private final E[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
        this.stack = (E[]) new Object[maxSize];
        this.top = -1;
    }

    @Override
    public void push(E value) {
        stack[++top] = value;
    }

    @Override
    public E pop() {
        return stack[top--];
    }

    @Override
    public E peek() {
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }
}
