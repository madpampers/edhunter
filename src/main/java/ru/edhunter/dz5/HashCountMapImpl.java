/*
 * (c) edhunter.ru 2017
 */
package ru.edhunter.dz5;

import java.util.Map;
import java.util.HashMap;

/**
 * Implementation of interface CountMap, based on HashMap.
 *
 * @param <K> class of Keys.
 */
public final class HashCountMapImpl<K> implements CountMap<K> {
    /**
     * Map, that contains all elements of countMap.
     * */
    private final Map<K, Integer> countMap;

    /**
     * default constructor, initializes field countMap with new HashMap.
     */
    HashCountMapImpl() {
        this.countMap = new HashMap<>();
    }

    @Override
    public void add(K o) {
        if (countMap.containsKey(o)) {
            int count = countMap.get(o) + 1;
            countMap.put(o, count);
        } else {
            this.countMap.put(o, 1);
        }
    }

    @Override
    public int getCount(K o) {
        if (countMap.containsKey(o)) {
            return countMap.get(o);
        }
        return 0;
    }

    @Override
    public int remove(K o) {
        if (countMap.containsKey(o)) {
            return countMap.remove(o);
        }
        return 0;
    }

    @Override
    public int size() {
        return countMap.size();
    }

    @Override
    public void addAll(CountMap<? extends K> source) {
        Map<? extends K, Integer> tempMap = source.toMap();
        for (Map.Entry<? extends K, Integer> entry : tempMap.entrySet()) {
            if (this.getCount(entry.getKey()) == 0) {
                countMap.put(entry.getKey(), entry.getValue());
            } else {
                countMap.put(entry.getKey(), entry.getValue() + getCount(entry.getKey()));
            }
        }
    }

    @Override
    public Map<K, Integer> toMap() {
        return countMap;
    }

    @Override
    public void toMap(Map<? super K, ? super Integer> destination) {
        destination.putAll(countMap);
    }
}
