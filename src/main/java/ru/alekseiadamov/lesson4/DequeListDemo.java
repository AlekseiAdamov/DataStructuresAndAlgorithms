package ru.alekseiadamov.lesson4;

import ru.alekseiadamov.lesson4.core.DequeList;

public class DequeListDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Williams", 45);
        Person person2 = new Person("Jack", "Tuesday", 28);
        Person person3 = new Person("Wendy", "Cross", 35);
        Person person4 = new Person("Cindy", "Correlli", 35);

        DequeList<Person> people = new DequeList<>();
        people.insertLeft(person1);
        people.insertRight(person2);
        people.insertLeft(person3);
        people.insertRight(person4);

        people.display();
        System.out.println("----------");

        System.out.println("size(): " + people.size());
        System.out.println("----------");

        System.out.println("peek(): " + people.peek());
        System.out.println("----------");

        System.out.println("removeRight(): " + people.removeRight());
        System.out.println("removeLeft(): " + people.removeLeft());
        people.display();

        /* Result:

            Wendy Cross, age 35
            John Williams, age 45
            Jack Tuesday, age 28
            Cindy Correlli, age 35
            ----------
            size(): 4
            ----------
            peek(): Wendy Cross, age 35
            ----------
            removeRight(): Cindy Correlli, age 35
            removeLeft(): Wendy Cross, age 35
            John Williams, age 45
            Jack Tuesday, age 28
        */
    }
}
