package ru.alekseiadamov.lesson4.core;

public class DequeList<T> {
    protected final LinkedList<T> list;
    protected int size;

    public DequeList() {
        list = new LinkedList<>();
        size = 0;
    }

    public void insertRight(T data) {
        list.insertLast(data);
        size++;
    }

    public T removeRight() {
        size--;
        T data = list.getLast().getData();
        return list.delete(data).getData();
    }

    public void insertLeft(T data) {
        list.insert(data);
        size++;
    }

    public T removeLeft() {
        size--;
        return list.delete().getData();
    }

    public T peek() {
        return list.getFirst().getData();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return size;
    }

    public void display() {
        list.display();
    }
}
