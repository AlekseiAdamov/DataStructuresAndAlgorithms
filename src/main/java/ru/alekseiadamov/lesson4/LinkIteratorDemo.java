package ru.alekseiadamov.lesson4;

import ru.alekseiadamov.lesson4.core.LinkIterator;
import ru.alekseiadamov.lesson4.core.LinkedList;

public class LinkIteratorDemo {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();
        LinkIterator<Person> iterator = new LinkIterator<>(people);

        Person person1 = new Person("John", "Williams", 45);    // 1
        Person person2 = new Person("Jack", "Tuesday", 28);     // 2
        Person person3 = new Person("Wendy", "Cross", 35);      // 3
        Person person4 = new Person("Cindy", "Correlli", 35);   // 4

        iterator.insertAfter(person1);
        iterator.insertBefore(person2);
        iterator.insertAfter(person3);
        iterator.insertBefore(person4);

        people.display();
        System.out.println("----------");

        System.out.println("getCurrent(): " + iterator.getCurrent().getData());
        System.out.println("atEnd(): " + iterator.atEnd());
        System.out.println("----------");

        System.out.println("reset():");
        iterator.reset();
        System.out.println(iterator.getCurrent().getData());
        System.out.println("----------");

        System.out.println("deleteCurrent():");
        System.out.println(iterator.deleteCurrent());
        people.display();
        System.out.println("----------");

        System.out.println("reset() + nextLink():");
        iterator.reset();
        iterator.nextLink();
        System.out.println(iterator.getCurrent().getData());

        /* Result:
            Jack Tuesday, age 28    // 2 (before 1)
            Cindy Correlli, age 35  // 4 (before 3)
            Wendy Cross, age 35     // 3 (after 2)
            John Williams, age 45   // 1
            ----------
            getCurrent(): Cindy Correlli, age 35
            atEnd(): false
            ----------
            reset():
            Jack Tuesday, age 28
            ----------
            deleteCurrent():
            Cindy Correlli, age 35
            Wendy Cross, age 35
            John Williams, age 45
            ----------
            reset() + nextLink():
            Wendy Cross, age 35
        */
    }
}
