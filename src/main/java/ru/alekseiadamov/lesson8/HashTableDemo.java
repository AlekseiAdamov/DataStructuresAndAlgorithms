package ru.alekseiadamov.lesson8;

import ru.alekseiadamov.lesson8.core.HashTable;
import ru.alekseiadamov.lesson8.implementation.DoubleHashTableImpl;
import ru.alekseiadamov.lesson8.implementation.HashTableImpl;
import ru.alekseiadamov.lesson8.implementation.HashTableWithChaining;
import ru.alekseiadamov.lesson8.util.Product;

public class HashTableDemo {

    public static void main(String[] args) {
        System.out.println("Hashtable with open addressing:");
        HashTable<Product, Integer> hashTable = new HashTableImpl<>(5);//5 * 2 = 10
        testHashTable(hashTable);

        System.out.println("----------");
        System.out.println("Hashtable with double hashing:");
        HashTable<Product, Integer> doubleHashTable = new DoubleHashTableImpl<>(5);//5 * 2 = 10
        testHashTable(doubleHashTable);

        System.out.println("----------");
        System.out.println("Hashtable with chaining:");
        HashTable<Product, Integer> hashTableWithChaining = new HashTableWithChaining<>(5);
        testHashTable(hashTableWithChaining);
    }

    private static void testHashTable(HashTable<Product, Integer> hashTable) {
        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(67, "Carrot"), 228);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(51, "Milk"), 120);
        hashTable.put(new Product(21, "Potato"), 67);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        System.out.println("----------");

        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        hashTable.put(new Product(47, "Pineapple"), 228);
        System.out.println("Size is " + hashTable.size());

        hashTable.display();
    }
}
