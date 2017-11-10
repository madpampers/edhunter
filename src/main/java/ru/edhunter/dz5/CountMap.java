package ru.edhunter.dz5;

import java.util.Map;

public interface CountMap<K> {

    void add(K o);

    int getCount(K o);

    int remove(K o);

    int size();

    void addAll(CountMap<? extends K> source);

    Map<K, Integer> toMap();

    void toMap(Map<? super K, ? super Integer> destination);
}
