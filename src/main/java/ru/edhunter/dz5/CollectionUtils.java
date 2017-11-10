package ru.edhunter.dz5;

import java.util.*;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        if (size > source.size()) {
            throw new IllegalArgumentException("Source size is smaller than limit");
        }

        if (source instanceof ArrayList<?>) {
            return new ArrayList<>(source.subList(0, size));
        } else {
            return new LinkedList<>(source.subList(0, size));
        }
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> whichContains, List<T> c) {
        return whichContains.containsAll(c);
    }

    public static <T> boolean containsAny(List<? super T> whichContains, List<T> c) {
        for (T element : c) {
            if (whichContains.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Object & Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> range = createNewList(list);
        for (T element : list) {
            if (element.compareTo(min) >= 0 && element.compareTo(max) <= 0) {
                add(range, element);
            }
        }
        return range;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> rangedList = createNewList(list);
        for (T element : list) {
            if (comparator.compare(element, min) >= 0 && comparator.compare(element, max) <= 0) {
                add(rangedList, element);
            }
        }
        return rangedList;
    }

    private static <T> List<T> createNewList(List<?> list) {
        if (list instanceof LinkedList) {
            return new LinkedList<>();
        } else {
            return new ArrayList<>();
        }
    }
}
