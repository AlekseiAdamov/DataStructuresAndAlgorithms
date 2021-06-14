package ru.alekseiadamov.lesson8.core;

public interface Entry<K, V> {

    K getKey();

    V getValue();

    void setValue(V value);
}
