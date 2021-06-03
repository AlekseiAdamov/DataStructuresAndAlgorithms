package ru.alekseiadamov.lesson3;

public class DequeDemo {
    public static void main(String[] args) {
        DequeImpl<Integer> numbers = new DequeImpl<>(10);

        numbers.insertLeft(10);
        numbers.insertLeft(20);
        numbers.insertLeft(30);
        numbers.insertLeft(40);
        numbers.insertLeft(50);
        numbers.insertLeft(60);
        numbers.insertLeft(70);
        numbers.insertLeft(80);
        numbers.insertLeft(90);
        numbers.insertLeft(100);
        numbers.removeRight();
        numbers.removeRight();
        numbers.removeRight();
        numbers.removeRight();
        numbers.insertRight(10);
        numbers.insertRight(20);
        numbers.insertRight(30);
        numbers.insertRight(40);
        numbers.removeLeft();
        numbers.removeRight();
        numbers.insertLeft(5);
        numbers.insertRight(3);

        while (!numbers.isEmpty()) {
            System.out.print(numbers.removeLeft() + " ");
        }
        System.out.println();
    }
}
