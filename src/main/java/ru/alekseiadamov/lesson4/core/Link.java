package ru.alekseiadamov.lesson4.core;

public class Link<T> {
    private final T data;
    private Link<T> next;

    public Link(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public void display() {
        System.out.println(data.toString());
    }
}
