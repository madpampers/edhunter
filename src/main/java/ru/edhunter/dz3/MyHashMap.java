package ru.edhunter.dz3;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements Map<K, V> {
    private final List<Entry<K, V>>[] mapCells;
    private int size = 0;

    @SuppressWarnings("all")
    public MyHashMap(int length) {
        //какая то проблема с созданием типизированного массива, лучше использовать коллекцию в таких случаях наверное
        mapCells = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            mapCells[i] = new ArrayList<Entry<K, V>>();
        }
    }

    @Override
    public void put(K key, V value) {
        if (findKey(key) != -1) {
            getList(key).get(findKey(key)).setValue(value);
        } else {
            getList(key).add(new Entry<>(key, value));
            size++;
        }
    }

    @Override
    public V get(final K key) {
        int keyLoc = findKey(key);
        if (keyLoc != -1) {
            return getList(key).get(keyLoc).getValue();
        } else {
            return null;
        }
    }

    @Override
    public void remove(final K key) {
        if (findKey(key) != -1) {
            getList(key).remove(findKey(key));
            size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getCell(final K key) { //метод определяет нужный бакет по хешкоду
        return key.hashCode() % mapCells.length;
    }

    private List<Entry<K, V>> getList(K key) {//получаем список из нужного бакета
        return mapCells[getCell(key)];
    }

    private int findKey(final K key) { //в нужном бакете определяет где находится наша Entry
        int cell = getCell(key);
        for (int i = 0; i < getList(key).size(); i++) {
            if (mapCells[cell].get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("all")
    private static class Entry<K, V> {
        private final K key;
        private V value;

        Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}