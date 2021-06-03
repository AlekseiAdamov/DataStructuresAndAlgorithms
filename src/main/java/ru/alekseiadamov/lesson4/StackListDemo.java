package ru.alekseiadamov.lesson4;

import ru.alekseiadamov.lesson4.core.StackList;

public class StackListDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Williams", 45);
        Person person2 = new Person("Jack", "Tuesday", 28);
        Person person3 = new Person("Wendy", "Cross", 35);
        Person person4 = new Person("Cindy", "Correlli", 35);

        StackList<Person> people = new StackList<>();
        people.push(person1);
        people.push(person2);
        people.push(person3);
        people.push(person4);
        people.display();
        System.out.println("----------");

        while (!people.isEmpty()) {
            System.out.println("Person '" + people.pop() + "' is deleted from stack");
        }
        /* Result:
            Cindy Correlli, age 35
            Wendy Cross, age 35
            Jack Tuesday, age 28
            John Williams, age 45
            ----------
            Person 'Cindy Correlli, age 35' is deleted from stack
            Person 'Wendy Cross, age 35' is deleted from stack
            Person 'Jack Tuesday, age 28' is deleted from stack
            Person 'John Williams, age 45' is deleted from stack
        */
    }
}
