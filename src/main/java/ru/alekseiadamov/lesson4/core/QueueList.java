package ru.alekseiadamov.lesson4.core;

public class QueueList<T> {
    private final LinkedList<T> queue;

    public QueueList() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(T data) {
        queue.insert(data);
    }

    public T delete() {
        return queue.delete().getData();
    }

    public void display() {
        queue.display();
    }

}
