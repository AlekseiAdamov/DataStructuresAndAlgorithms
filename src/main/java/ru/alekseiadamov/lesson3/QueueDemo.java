package ru.alekseiadamov.lesson3;

import ru.alekseiadamov.lesson3.core.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> numbers = new QueueImpl<>(10);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.remove();
        numbers.remove();
        numbers.insert(60);
        numbers.insert(70);
        numbers.insert(80);
        numbers.insert(90);

        while (!numbers.isEmpty()) {
            System.out.println(numbers.remove());
        }
    }
}
