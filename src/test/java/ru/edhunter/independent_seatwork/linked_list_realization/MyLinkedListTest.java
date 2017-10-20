package ru.edhunter.independent_seatwork.linked_list_realization;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MyLinkedListTest {
    private List<Integer> list = new MyLinkedList<>();

    @Test
    public void test1() {
        Assert.assertEquals(0, list.size()); //test init

        list.add(2); //test add
        list.add(3);
        list.add(4);

        Assert.assertEquals(3, list.size()); //test size

        ListIterator<Integer> listIterator = list.listIterator();

        Assert.assertEquals(listIterator.next(), listIterator.previous()); //test list iterator

        int count = -1;
        while (listIterator.hasNext()) {
            listIterator.next();
            count = listIterator.nextIndex();
        }
        Assert.assertEquals(list.size(), count);

        while (listIterator.hasPrevious()) {
            listIterator.previous();
            count = listIterator.previousIndex();
        }
        Assert.assertEquals(-1, count);

        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
        Assert.assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(7);

        listIterator = list.listIterator();

        listIterator.add(4);
        Assert.assertEquals(4, list.size());

        Assert.assertTrue(list.get(0) == 4);

        list.set(3, 9);
        Assert.assertTrue(list.get(3) == 9);
        Assert.assertTrue(9 == list.set(3, 3));

        list.add(0, 5);
        Assert.assertTrue(5 == list.get(0));
        Assert.assertTrue(5 == list.size());
        list.add(4, 99);
        Assert.assertTrue(99 == list.get(4));
        Assert.assertTrue(6 == list.size());
        list.remove(4);
        Assert.assertTrue(3 == list.get(4));
    }

    @Test
    public void test2() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Assert.assertEquals(0, list.indexOf("a"));
        Assert.assertEquals(2, list.indexOf("c"));
        Assert.assertEquals(4, list.indexOf("e"));
        list.add(0, "a");
        Assert.assertEquals(1, list.lastIndexOf("a"));
        Assert.assertEquals(3, list.indexOf("c"));
    }

    @Test
    public void test3() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        Iterator<String> iterator = list.iterator();
        Assert.assertEquals("a", iterator.next());
        iterator.next();
        iterator.next();
        iterator.next();
        Assert.assertEquals("e", iterator.next());
    }

    @Test
    public void test4() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        Object[] strings = list.toArray();
        for (int i = 0; i < strings.length; i++) {
            Assert.assertEquals(strings[i], list.get(i));
        }
    }

    @Test
    public void test5() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        List<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        Assert.assertTrue(list.containsAll(list1));

        list1.add("bad");
        Assert.assertFalse(list.containsAll(list1));

        List<String> test = new MyLinkedList<>();
        test.add("a");
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("bad");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");

        list.addAll(1, list1);
        Assert.assertTrue(list.size() == test.size());
        int i = 0;
        for (String string : list) {
            Assert.assertEquals(string, test.get(i++));
        }

        list.removeAll(list1);
        Assert.assertEquals(2, list.size());

        test.retainAll(list1);
        Assert.assertEquals(7, test.size());
    }

    @Test(expected = IllegalStateException.class)
    public void test6() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iterator = list.listIterator();
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void test7() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.add("f");
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void test8() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.remove();
        iterator.remove();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test9() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        list.remove("a");
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test10() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        List<String> list1 = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ListIterator<String> iterator = list.listIterator();
        list.removeAll(list1);
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test11() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (String string : list) {
            list.remove(string);
        }
    }

    @Test
    public void test12() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        ListIterator<String> iterator = list.listIterator();
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(iterator.next(), iterator.previous());
        }
    }

    @Test
    public void test13() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.clear();
        Assert.assertEquals(0, list.size());
        list.add("f");
        Assert.assertEquals(0,list.indexOf("f"));
        Assert.assertEquals("f", list.get(list.size()-1));
    }

    @Test
    public void test14() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        MyLinkedList<String> list1 = new MyLinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        list.reverse();

        int i = list.size()-1;
        for (String string : list1) {
            Assert.assertEquals(string, list.get(i--));
        }

    }

    @Test
    public void test15() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        List<String> subList = list.subList(2,list.size());

        int i = 2;
        for (String string : subList) {
            Assert.assertEquals(string, list.get(i++));
        }
    }

    @Test
    public void test16() {
        List<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        String[] a = new String[3];
        String[] b = list.toArray(a);

        for (String string : b) {
            System.out.println(string);
        }
    }
}
