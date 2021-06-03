package ru.alekseiadamov.lesson4.core;

public class LinkedList<T> {
    private Link<T> first;
    private Link<T> last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public Link<T> getFirst() {
        return first;
    }

    public void setFirst(Link<T> first) {
        this.first = first;
    }

    public Link<T> getLast() {
        return last;
    }

    public void setLast(Link<T> last) {
        this.last = last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T data) {
        Link<T> link = new Link<>(data);
        if (isEmpty()) {
            last = link;
        }
        link.setNext(first);
        first = link;
    }

    public void insertLast(T data) {
        Link<T> link = new Link<>(data);
        if (isEmpty()) {
            first = link;
        } else {
            last.setNext(link);
        }
        last = link;
    }

    public Link<T> delete() {
        Link<T> link = first;
        if (first.getNext() == null) {
            last = null;
        }
        first = first.getNext();
        return link;
    }

    public void display() {
        Link<T> current = first;
        while (current != null) {
            current.display();
            current = current.getNext();
        }
    }

    public T find(T searchNode) {
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null) {
            if (current.getData().equals(findNode.getData())) {
                return findNode.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public Link<T> delete(T searchNode) {
        Link<T> current = first;
        Link<T> previous = first;
        while (!current.getData().equals(searchNode)) {
            if (current.getNext() == null)
                return null;
            else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        return current;
    }

}
