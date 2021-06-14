package ru.alekseiadamov.lesson8.implementation;

import ru.alekseiadamov.lesson8.core.HashTable;

import java.util.LinkedList;

/**
 * Implementation of the {@link HashTable} interface using the separate chaining technique.
 *
 * @param <K> The key.
 * @param <V> The value.
 */
public class HashTableWithChaining<K, V> implements HashTable<K, V> {
    private final LinkedList<Item<K, V>>[] buckets;
    private int size;

    /**
     * Class constructor.
     *
     * @param initialCapacity Starting capacity of the hashtable buckets array.
     */
    @SuppressWarnings("unchecked")
    public HashTableWithChaining(int initialCapacity) {
        this.buckets = new LinkedList[initialCapacity];
    }

    /**
     * @param key The key to get the index of the hashtable.
     * @return Index of the key in the hashtable.
     */
    private int hashFunc(K key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Adds a new key-value pair if there is no specified key in the hashtable.
     * If the key already exists, sets the new value to this key.
     *
     * @param key   The required key.
     * @param value The value corresponding to the key.
     * @return True if the new pair was added, otherwise false.
     */
    @Override
    public boolean put(K key, V value) {
        int bucketIndex = hashFunc(key);
        // How can it be possible?
        if (bucketIndex == -1) {
            return false;
        }
        // If there is no bucket for the index, creates new bucket.
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }
        LinkedList<Item<K, V>> bucket = buckets[bucketIndex];
        // If key exists, sets the new value.
        for (Item<K, V> item : bucket) {
            if (isKeysEqual(item, key)) {
                item.setValue(value);
                return true;
            }
        }
        // If key doesn't exist, adds new item to the bucket.
        bucket.add(new Item<>(key, value));
        size++;
        return true;
    }

    /**
     * @param key Required key.
     * @return The value corresponding to the key.
     */
    @Override
    public V get(K key) {
        int bucketIndex = indexOf(key);

        if (bucketIndex == -1) {
            return null;
        }

        LinkedList<Item<K, V>> bucket = buckets[bucketIndex];
        if (bucket == null) {
            return null;
        }
        for (Item<K, V> item : bucket) {
            if (isKeysEqual(item, key)) {
                return item.getValue();
            }
        }
        return null;
    }

    /**
     * @param key Required key.
     * @return The index of the bucket containing the specified key.
     */
    private int indexOf(K key) {
        return hashFunc(key);
    }

    /**
     * Checks whether the key of the item is equal to the specified key.
     *
     * @param item The item whose key is to be checked.
     * @param key  The key to check for equality with the item's key.
     * @return True if the keys are equal, otherwise false.
     */
    private boolean isKeysEqual(Item<K, V> item, K key) {
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    /**
     * Removes the item by its key.
     *
     * @param key Required key.
     * @return Removed item's value.
     */
    @Override
    public V remove(K key) {
        int bucketIndex = indexOf(key);
        if (bucketIndex == -1) {
            return null;
        }

        if (buckets[bucketIndex] == null) {
            return null;
        }
        V value = null;
        LinkedList<Item<K, V>> bucket = buckets[bucketIndex];
        for (Item<K, V> item : bucket) {
            if (isKeysEqual(item, key)) {
                value = item.getValue();
                bucket.remove(item);
            }
        }
        size--;
        return value;
    }

    /**
     * @return Number of keys in the hashtable.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return True if the hashtable is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the content of the hashtable.
     */
    @Override
    public void display() {
        System.out.println("----------");
        System.out.println("Hash table content:");
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Item<K, V>> bucket = buckets[i];
            if (bucket == null) {
                continue;
            }
            for (Item<K, V> item : bucket) {
                if (item == null) {
                    continue;
                }
                System.out.printf("\t%d: %s\n", i, item);
            }
        }
        System.out.println("----------");
    }
}
