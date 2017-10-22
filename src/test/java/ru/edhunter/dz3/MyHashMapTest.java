package ru.edhunter.dz3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class MyHashMapTest {
    private List<Integer> list;
    private Map<Integer, Integer> myMap;
    private Random random;

    @Test
    public void testInitialSize() {
        Map<Integer, String> map = new MyHashMap<>(3);
        assertEquals(0, map.size());
    }

    @Test
    public void testSizeAfterAdded() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.put(1, "a");
        assertEquals(1, map.size());
        map.put(2, "b");
        assertEquals(2, map.size());
        map.put(3, "c");
        assertEquals(3, map.size());
    }

    @Test
    public void testSizeAfterAddedWithSameKey() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.put(1, "a");
        assertEquals(1, map.size());
        map.put(1, "b");
        assertEquals(1, map.size());
    }

    @Test
    public void testGetFromEmptyCollection() {
        Map<Integer, String> map = new MyHashMap<>(3);
        assertEquals(0, map.size());
        assertEquals(null, map.get(0));
    }

    @Test
    public void testPutInAndGetFromCollection() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.put(1, "a");
        assertEquals("a", map.get(1));
        map.put(2, "b");
        assertEquals("b", map.get(2));
    }

    @Test
    public void testPutSameKeyButDifferentValue() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.put(1, "a");
        assertEquals("a", map.get(1));
        map.put(1, "b");
        assertEquals("b", map.get(1));
    }

    @Test
    public void testRemove() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.remove(1);
        assertEquals(null, map.get(1));
        assertEquals(2, map.size());
        map.remove(2);
        assertEquals(null, map.get(2));
        assertEquals(1, map.size());
        map.remove(3);
        assertEquals(null, map.get(3));
        assertEquals(0, map.size());
    }

    @Test
    public void testSizeAfterRemovingFromEmptyMap() {
        Map<Integer, String> map = new MyHashMap<>(3);
        map.remove(1);
        assertEquals(0, map.size());
        map.put(1, "a");
        map.remove(1);
        map.remove(1);
        map.remove(10);
        assertEquals(0, map.size());
    }

    //LETS DO SOME BENCHMARKS!!!
    @Before
    public void prepare() {
        list = new LinkedList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(0);
        }
        myMap = new MyHashMap<>(50000);
        random = new Random();
    }

    @Test
    public void testBenchAddingElement() {
        //Тестируем обычный ЛинкедЛист (сложность O(n))
        Long start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            list.set(Math.abs(random.nextInt(list.size())), Math.abs(random.nextInt()));
        }
        Long finish = new Date().getTime();
        Long arrayListResult = finish - start; //считаем за какое время лист управился
        //Теперь тестируем нашу имплементацию HashMap (сложность O(1))
        start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            myMap.put(Math.abs(random.nextInt()), Math.abs(random.nextInt()));
        }
        finish = new Date().getTime();
        Long myMapResult = finish - start;//получаем время работы нашей мапы
        //сравним результаты, если результат отличается более чем в 10 раз (условно) тест проходит
        assertEquals(true, myMapResult < arrayListResult/10);
        //остальные тесты сделаны по принципу этого теста, только тестируют другие методы
    }

    @Test
    @SuppressWarnings("all")
    public void testBenchGetElement() {

        Long start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            list.get(Math.abs(random.nextInt(list.size())));
        }
        Long finish = new Date().getTime();
        Long arrayListResult = finish - start;

        start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            myMap.get(Math.abs(random.nextInt()));
        }
        finish = new Date().getTime();
        Long myMapResult = finish - start;

        assertEquals(true, myMapResult < arrayListResult/10);

    }


    @Test
    @SuppressWarnings("all")
    public void testBenchRemoveElement() {

        Long start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            list.remove(Math.abs(random.nextInt(list.size())));
        }
        Long finish = new Date().getTime();
        Long arrayListResult = finish - start;

        start = new Date().getTime();
        for (int i = 0; i < 50000; i++) {
            myMap.remove(Math.abs(random.nextInt()));
        }
        finish = new Date().getTime();
        Long myMapResult = finish - start;
        assertEquals(true, myMapResult < arrayListResult/10);

    }

}
