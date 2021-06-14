package ru.alekseiadamov.lesson8.core;

public interface HashTable<K, V> {
    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    boolean isEmpty();

    void display();
}
