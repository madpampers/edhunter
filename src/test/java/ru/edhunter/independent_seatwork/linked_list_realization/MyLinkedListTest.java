package ru.edhunter.independent_seatwork.linked_list_realization;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class MyLinkedListTest {

    @Test
    public void testSizeWhenSizeIs0() {
        final List<Integer> testList = new MyLinkedList<>();
        assertEquals(0, testList.size());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        final List<Integer> testList = new MyLinkedList<>();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void testToArrayWhenInputArrayHaveSizeOne() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        final Integer[] input = new Integer[1];
        final Integer[] result = testList.toArray(input);
        assertNotEquals(input, result);
        assertEquals((Integer) 1, result[0]);
        assertEquals((Integer) 2, result[1]);
        assertEquals((Integer) 3, result[2]);
        assertEquals(3, result.length);
    }

    @Test
    public void testToArrayWhenInputArrayHaveCorrectSize() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        final Integer[] input = new Integer[3];
        final Integer[] result = testList.toArray(input);
        assertEquals(input, result);
    }

    @Test
    public void testContains() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        assertTrue(testList.contains(1));
        assertFalse(testList.contains(0));
    }

    @Test
    public void testAdd() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(1);
        assertEquals(2, testList.size());
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testRemoveFirstElement() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.remove(1);
        assertEquals(1, testList.size());
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testRemoveLastElement() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.remove(new Integer(2));
        assertEquals(1, testList.size());
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testContainsAll() {
        final List<Integer> testList = new MyLinkedList<>();
        final List<Integer> testList2 = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList2.add(2);
        testList2.add(1);
        assertTrue(testList.containsAll(testList2));
    }

    @Test
    public void testAddAll() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        assertTrue(testList.contains(3));
        assertTrue(testList.contains(4));
    }

    @Test
    public void testRemoveAll() {
        final List<Integer> testList = new MyLinkedList<>();
        final List<Integer> testList2 = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList2.add(2);
        testList2.add(3);
        testList.removeAll(testList2);
        assertEquals(1, testList.size());
        assertTrue(testList.contains(1));
    }

    @Test
    public void testRetainAll() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        final MyLinkedList<Integer> testList2 = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList2.add(2);
        testList2.add(3);
        testList.retainAll(testList2);
        assertEquals(1, testList.size());
        assertTrue(testList.contains(2));
    }

    @Test
    public void testClear() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(1);
        testList.clear();
        assertTrue(testList.isEmpty());
        assertEquals(0, testList.size());
    }

    @Test
    public void testRemoveByIndex() {
        final List<String> testList = new MyLinkedList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        assertEquals("b", testList.remove(1));
        assertEquals(3, testList.size());
        assertEquals("d", testList.remove(2));
        assertEquals(2, testList.size());
        assertEquals("a", testList.remove(0));
        assertEquals(1, testList.size());
        testList.remove(0);
        assertEquals(0, testList.size());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIncorrectIndex() {
        final List<String> testList = new MyLinkedList<>();
        testList.add("a");
        testList.remove(5);
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveBeforeNext() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(2);
        final Iterator<Integer> iterator = testList.iterator();
        iterator.remove();

    }

    @Test(expected = NoSuchElementException.class)
    public void testNextOnEmptyCollection() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        final Iterator<Integer> iterator = testList.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        iterator.next();
    }

    @Test
    public void testHasPreviousWhenIteratorAtTheEndOfTheCollection() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
    }

    @Test
    public void testPreviousIndexWhenItEqualsTo1() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(1);

        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.next();
        listIterator.next();

        assertEquals(1, listIterator.previousIndex());
    }

    @Test(expected = IllegalStateException.class)
    public void testSetWhenNeitherNextNorPreviousHaveBeenCalled() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.set(null);
    }

    @Test
    public void testSet() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.next();
        listIterator.set(2);
        assertEquals((Integer) 2, testList.get(0));
    }

    @Test
    public void testPreviousOnCollectionWithOneElement() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        final ListIterator<Integer> listIterator = testList.listIterator();
        final Integer next = listIterator.next();
        final Integer previous = listIterator.previous();
        assertEquals(next, previous);
    }

    @Test
    public void testPreviousIndex() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());
    }

    @Test
    public void testPreviousIndexWhenEmptyCollection() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        final ListIterator<Integer> listIterator = testList.listIterator();
        assertEquals(-1, listIterator.previousIndex());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPreviousWhenEmptyCollection() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        final ListIterator<Integer> listIterator = testList.listIterator();
        listIterator.previous();
    }

    @Test
    public void testHasPreviousWhenEmptyCollection() {
        final MyLinkedList<Integer> testList = new MyLinkedList<>();
        final ListIterator<Integer> listIterator = testList.listIterator();
        assertFalse(listIterator.hasPrevious());
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveTwoTimeInTheRow() {
        final List<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        final Iterator<Integer> iterator = testList.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(1, testList.size());
        iterator.remove();
    }

    @Test
    public void testReverseMethod() {
        final MyLinkedList<String> testList = new MyLinkedList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        testList.add("e");
        final MyLinkedList<String> controlTestList = new MyLinkedList<>();
        controlTestList.add("e");
        controlTestList.add("d");
        controlTestList.add("c");
        controlTestList.add("b");
        controlTestList.add("a");
        testList.reverse();
        int count = 0;
        for (String string : testList) {
            assertEquals(string,controlTestList.get(count++));
        }
        testList.reverse();
        count = 4;
        for (String string : testList) {
            assertEquals(string, controlTestList.get(count--));
        }
    }
}