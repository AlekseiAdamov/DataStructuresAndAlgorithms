package ru.alekseiadamov.lesson8.implementation;

import ru.alekseiadamov.lesson8.core.Entry;

public class Item<K, V> implements Entry<K, V> {
    private final K key;
    private V value;

    public Item(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
