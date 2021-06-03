package ru.alekseiadamov.lesson4.core;

public class StackList<T> {
    private final LinkedList<T> list;

    public StackList(){
        list = new LinkedList<>();
    }

    public void push(T data){
        list.insert(data);
    }

    public T pop(){
        return list.delete().getData();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }

}
