/*
 * (c) edhunter.ru 2017
 */
package ru.edhunter.dz5;

import java.util.Map;

/**
 * Interface for Map, that contains entries Key-Value, where Key element of any type,
 * and Value - count of times, that element was placed in CountMap.
 *
 * @param <K> - class of keys;
 */
public interface CountMap<K> {
    /**
     * Adds element to map, if map already contains that key, value of that key
     * increments by 1.
     *
     * @param o some element, placed in CountMap.
     */
    void add(K o);

    /**
     * Returns value of CountMap by key.
     *
     * @param o element of map, which value method returns.
     * @return value, that shows how many times object 'o' was placed in CountMap.
     */
    int getCount(K o);

    /**
     * Removes element 'o' from CountMap.
     *
     * @param o element, which removes from map.
     * @return value, that shows how many times object 'o' was placed in CountMap.
     */
    int remove(K o);

    /**
     * Shows size of map.
     *
     * @return countMap size.
     */
    int size();

    /**
     * Adds all elements from source CountMap to current CountMap.
     *
     * @param source countMap, from which elements are taken.
     */
    void addAll(CountMap<? extends K> source);

    /**
     * Converts CountMap to Map.
     *
     * @return return map, with entries types of "K - Integer";
     */
    Map<K, Integer> toMap();

    /**
     * Inserts all of the elements of this CountMap to the specified map.
     *
     * @param destination map, countMap elements inserts to.
     */
    void toMap(Map<? super K, ? super Integer> destination);
}
