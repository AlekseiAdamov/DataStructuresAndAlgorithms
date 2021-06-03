package ru.alekseiadamov.lesson3;

import java.util.Arrays;

public class StackDemo {
    public static void main(String[] args) {
        String phrase = "Murder for a jar of red rum";
        System.out.println(phrase);

        String[] words = phrase.split(" ");
        StackImpl<String> stringStack = new StackImpl<>(words.length);
        Arrays.stream(words).forEach(stringStack::push);

        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
        System.out.println();

        StackImpl<Character> charStack = new StackImpl<>(phrase.length());
        for (int i = 0; i < phrase.length(); i++) {
            charStack.push(phrase.charAt(i));
        }

        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop());
        }
        System.out.println();
    }
}
