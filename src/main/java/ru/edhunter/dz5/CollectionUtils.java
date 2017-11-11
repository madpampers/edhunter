/*
 * (c) edhunter.ru 2017
 */
package ru.edhunter.dz5;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class consists exclusively of static methods that operate on or return collections.
 */
public final class CollectionUtils {
    /**
     * Constructor is private, to prevent instancing.
     */
    private CollectionUtils() {
    }

    /**
     * Adds all elements from source List to destination List.
     *
     * @param <T>         the class of the elements to add and of the List.
     * @param source      list from which elements are to be inserted.
     * @param destination list into which elements are to be inserted.
     */
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    /**
     * Static creation of ArrayList.
     *
     * @param <T> the class of the elements of List.
     * @return returns newly created ArrayList.
     */
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in source list, or -1 if this list does not contain the element.
     *
     * @param source List, in which to search for the first occurrence of target.
     * @param o      element to search for
     * @return index of provided element in list, or -1 if it is not present.
     */
    public static int indexOf(List<?> source, Object o) {
        return source.indexOf(o);
    }

    /**
     * Returns sublist of source List.
     *
     * @param <T>    the class of the elements of List.
     * @param source List, in which will be limit.
     * @param size   size List, to whic list will be cut.
     * @return List, which size is limits to 'size' argument, it contains all elements from
     * source List, from 0 to 'size.
     */
    public static <T> List<T> limit(List<? extends T> source, int size) {
        if (size > source.size() || size < 0) {
            throw new IllegalArgumentException("Value of limit is out of List bounds");
        }

        if (source instanceof ArrayList<?>) {
            return new ArrayList<>(source.subList(0, size));
        } else {
            return new LinkedList<>(source.subList(0, size));
        }
    }

    /**
     * Adds element 'o' to provided List.
     *
     * @param <T>    the class of the elements of List.
     * @param source List, to which will 'o' be added.
     * @param o      element, that will be inserted to List.
     */
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    /**
     * Removes all elements from 'removeFrom' List, that List 'c2' contains.
     *
     * @param <T>        the class of the elements of List.
     * @param removeFrom List, from which elements will be deleted.
     * @param c2         List, containing elements to be removed from 'removeFrom' list.
     */
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    /**
     * Returns true if this list contains all of the elements of the specified list.
     *
     * @param <T>           the class of the elements of List.
     * @param whichContains List, which elements checked for containing elements from List 'c'.
     * @param c             List to be checked for containment in this list.
     * @return true if 'whichContains' list contains all of the elements of the specified list
     */
    public static <T> boolean containsAll(List<? super T> whichContains, List<T> c) {
        return whichContains.containsAll(c);
    }

    /**
     * Returns true if this list contains any of the elements of the specified list.
     *
     * @param <T>           the class of the elements of List.
     * @param whichContains List, which elements checked for containing elements from List 'c'.
     * @param c             List to be checked for containment in this list.
     * @return true if 'whichContains' list contains any of the elements of the specified list
     */
    public static <T> boolean containsAny(List<? super T> whichContains, List<T> c) {
        for (T element : c) {
            if (whichContains.contains(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns List, which elements are in range from 'min' to 'max' (included). Elements of list must imlement
     * interface 'Comparable', to be compared with min and max elements.
     *
     * @param <T>  the class of the elements of List.
     * @param list List, which elements checked to match range of 'min' to 'max'.
     * @param min  minimal element, that acceptable for result List.
     * @param max  maximal element, that acceptable for result List.
     * @return List of elements, where every element is in range from 'min' to 'max' (included).
     */
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> range = createNewList(list);
        for (T element : list) {
            if (element.compareTo(min) >= 0 && element.compareTo(max) <= 0) {
                add(range, element);
            }
        }
        return range;
    }

    /**
     * Returns List, which elements are in range from 'min' to 'max' (included).
     *
     * @param <T>        the class of the elements of List.
     * @param list       List, which elements checked to match range of 'min' to 'max'.
     * @param min        minimal element, that acceptable for result List.
     * @param max        maximal element, that acceptable for result List.
     * @param comparator Instance of comparator, that provides comparing of elements.
     * @return List of elements, where every element is in range from 'min' to 'max' (included).
     */
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> rangedList = createNewList(list);
        for (T element : list) {
            if (comparator.compare(element, min) >= 0 && comparator.compare(element, max) <= 0) {
                add(rangedList, element);
            }
        }
        return rangedList;
    }

    /**
     * private method-helper, that creates new instance of List, based on instanceOF of specified list.
     *
     * @param <T>  the class of the elements of List.
     * @param list instance of list, which checked for being instance of what implementation it is.
     * @return new instance of List, based on instanceOF of specified list.
     */
    private static <T> List<T> createNewList(List<?> list) {
        if (list instanceof LinkedList<?>) {
            return new LinkedList<>();
        } else {
            return new ArrayList<>();
        }
    }
}
