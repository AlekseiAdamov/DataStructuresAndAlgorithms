package ru.alekseiadamov.lesson4;

import ru.alekseiadamov.lesson4.core.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.insert("Artem");
        list.insert("Roman");

        System.out.println(list.find("Artem"));

        Person person1 = new Person("John", "Williams", 45);
        Person person2 = new Person("Jack", "Tuesday", 28);
        Person person3 = new Person("Wendy", "Cross", 35);
        Person person4 = new Person("Cindy", "Correlli", 35);

        LinkedList<Person> people = new LinkedList<>();
        people.insert(person1);
        people.insert(person2);
        people.insert(person3);
        people.insert(person4);

        System.out.println(people.find(new Person("Jack", "Tuesday", 28)));
        System.out.println(people.find(new Person("Sam", "Bennett", 15)));
        System.out.println("----------");

        people.display();
        System.out.println("----------");

        System.out.println("delete(): " + people.delete().getData());
        System.out.println("delete(person2): " + people.delete(person2).getData());
        people.display();
        System.out.println("----------");

        people.insertLast(person2);
        people.insertLast(person4);
        people.display();

        /*Result:
            Artem
            Jack Tuesday, age 28
            null
            ----------
            Cindy Correlli, age 35
            Wendy Cross, age 35
            Jack Tuesday, age 28
            John Williams, age 45
            ----------
            delete(): Cindy Correlli, age 35
            delete(person2): Jack Tuesday, age 28
            Wendy Cross, age 35
            John Williams, age 45
            ----------
            Wendy Cross, age 35
            John Williams, age 45
            Jack Tuesday, age 28
            Cindy Correlli, age 35
        */
    }
}

