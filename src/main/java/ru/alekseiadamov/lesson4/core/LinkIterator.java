package ru.alekseiadamov.lesson4.core;

public class LinkIterator<T> {
    private Link<T> current;
    private Link<T> previous;
    private final LinkedList<T> list;

    public LinkIterator(LinkedList<T> list) {
        this.list = list;
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.getNext() == null);
    }

    public void nextLink(){
        previous = current;
        current = current.getNext();
    }

    public Link<T> getCurrent(){
        return current;
    }

    public void insertAfter(T data){
        Link<T> newLink = new Link<>(data);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    public void insertBefore(T data){
        Link<T> newLink = new Link<>(data);
        if(previous == null){
            newLink.setNext(list.getFirst());
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    public T deleteCurrent(){
        T data = current.getData();
        if (previous == null){
            list.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()){
                reset();
            } else {
                current = current.getNext();
            }
        }
        return data;
    }
}
