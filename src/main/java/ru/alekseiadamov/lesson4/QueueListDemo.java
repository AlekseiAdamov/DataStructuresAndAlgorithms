package ru.alekseiadamov.lesson4;

import ru.alekseiadamov.lesson4.core.QueueList;

public class QueueListDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Williams", 45);
        Person person2 = new Person("Jack", "Tuesday", 28);
        Person person3 = new Person("Wendy", "Cross", 35);
        Person person4 = new Person("Cindy", "Correlli", 35);

        QueueList<Person> people = new QueueList<>();
        people.insert(person1);
        people.insert(person2);
        people.insert(person3);
        people.insert(person4);
        people.display();
        System.out.println("----------");

        while (!people.isEmpty()) {
            System.out.println("Person '" + people.delete() + "' is deleted from queue");
        }

        /* Result:
            Cindy Correlli, age 35
            Wendy Cross, age 35
            Jack Tuesday, age 28
            John Williams, age 45
            ----------
            Person 'Cindy Correlli, age 35' is deleted from queue
            Person 'Wendy Cross, age 35' is deleted from queue
            Person 'Jack Tuesday, age 28' is deleted from queue
            Person 'John Williams, age 45' is deleted from queue
        */
    }
}
