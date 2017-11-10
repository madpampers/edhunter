package ru.edhunter.dz5;

import org.junit.Assert;
import org.junit.Test;
import ru.edhunter.dz5.fortests.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class TestCollectionUtils {

    @Test
    public void testAddAll() {
        List<Eatable> eatables = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Pineapple> pineapples = new ArrayList<>();

        apples.add(new Apple(3));
        apples.add(new Apple(3));
        apples.add(new Apple(2));

        pineapples.add(new Pineapple(2));
        pineapples.add(new Pineapple(3));

        CollectionUtils.addAll(apples, fruits);
        CollectionUtils.addAll(pineapples, eatables);
        CollectionUtils.addAll(fruits, eatables);

        assertEquals(5, eatables.size());
    }

    @Test
    public void testNewArrayList() {
        List<String> strings = CollectionUtils.newArrayList();
        strings.add("123");
        Assert.assertEquals("123".getClass(), strings.get(0).getClass());
    }

    @Test
    public void testIndexOf(){
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Eatable> eatables = new ArrayList<>();

        Apple redApple = new Apple(3);
        Pineapple bigPineapple = new Pineapple(3);
        Fruit strangeFruit = new Fruit(2);

        fruits.add(redApple);
        fruits.add(bigPineapple);
        fruits.add(strangeFruit);

        assertEquals(0, CollectionUtils.indexOf(fruits ,redApple));
        assertEquals(1, CollectionUtils.indexOf(fruits ,bigPineapple));
        assertEquals(2, CollectionUtils.indexOf(fruits ,strangeFruit));

        CollectionUtils.addAll(fruits, eatables);

        assertEquals(0, CollectionUtils.indexOf(eatables ,redApple));
        assertEquals(1, CollectionUtils.indexOf(eatables ,bigPineapple));
        assertEquals(2, CollectionUtils.indexOf(eatables ,strangeFruit));

        apples.add(redApple);

        assertEquals(0, CollectionUtils.indexOf(apples ,redApple));
    }

    @Test
    public void testLimit() {
        List<Fruit> fruits;
        List<Apple> apples = new ArrayList<>();

        Apple redApple = new Apple(3);
        Apple greenApple = new Apple(3);
        Apple smallRedApple = new Apple(1);

        apples.add(redApple);
        apples.add(greenApple);
        apples.add(smallRedApple);

        fruits = CollectionUtils.limit(apples, 2);

        assertEquals(2, fruits.size());
    }

    @Test
    public void testAdd() {
        List<Fruit> fruits = new ArrayList<>();

        Apple redApple = new Apple(3);
        Apple greenApple = new Apple(3);
        Apple smallRedApple = new Apple(1);

        CollectionUtils.add(fruits, redApple);
        CollectionUtils.add(fruits, greenApple);
        CollectionUtils.add(fruits, smallRedApple);

        assertEquals(3, fruits.size());
        assertEquals(0, CollectionUtils.indexOf(fruits, redApple));
    }

    @Test
    public void testRemoveAll() {
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();

        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(3);

        fruits.add(apple1);
        fruits.add(apple2);
        fruits.add(apple3);
        fruits.add(new Pineapple(3));

        apples.add(apple1);
        apples.add(apple2);

        CollectionUtils.removeAll(fruits, apples);

        assertEquals(2, fruits.size());
        assertEquals(apple3, fruits.get(0));
        assertEquals(new Pineapple(3), fruits.get(1));
    }

    @Test
    public void testContainsAll() {
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Apple> apples2 = new ArrayList<>();

        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(3);

        fruits.add(apple1);
        fruits.add(apple2);
        fruits.add(apple3);

        apples.add(apple1);
        apples.add(apple2);

        apples2.add(new Apple(4));
        apples2.add(apple1);
        apples2.add(apple2);

        assertTrue(CollectionUtils.containsAll(fruits, apples));
        assertFalse(CollectionUtils.containsAll(fruits, apples2));
    }

    @Test
    public void testContainsAny() {
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Apple> apples2 = new ArrayList<>();

        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(3);
        Apple apple4 = new Apple(4);

        fruits.add(apple1);

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);

        apples2.add(apple4);

        assertTrue(CollectionUtils.containsAny(fruits, apples));
        assertFalse(CollectionUtils.containsAny(apples2, apples));
    }

    @Test
    public void testRangeComparable () {
        List<Apple> apples = new ArrayList<>();

        //CUCUMBERS ARE NOT COMPARABLE!!! :)
//        List<Cucumber> cucumbers = new ArrayList<>();
//
//        cucumbers.add(new Cucumber(1));
//        cucumbers.add(new Cucumber(2));
//        cucumbers.add(new Cucumber(3));
//        cucumbers.add(new Cucumber(4));
//        cucumbers.add(new Cucumber(5));
//
//        Cucumber minCucum = new Cucumber(2);
//        Cucumber maxCucum = new Cucumber(4);

        apples.add(new Apple(1));
        apples.add(new Apple(2));
        apples.add(new Apple(3));
        apples.add(new Apple(4));
        apples.add(new Apple(5));

        Apple minimumApple = new Apple(2);
        Apple maximumApple = new Apple(4);

        List<Apple> mediumApples = CollectionUtils.range(apples, minimumApple, maximumApple);
        List<Fruit> mediumFruits = CollectionUtils.range(apples, minimumApple, maximumApple);

//        List<Vegetables> vegetables = CollectionUtils.range(cucumbers, minCucum, maxCucum);

        assertEquals(3, mediumApples.size());
        assertEquals(3, mediumFruits.size());
    }

    @Test
    public void testRangeComparator () {
        Comparator<Eatable> comparator = new Comparator<Eatable>() {
            @Override
            public int compare(Eatable o1, Eatable o2) {
                return Integer.compare(o1.getTasteRating()+o1.getSize(), o2.getTasteRating()+o2.getSize());
            }
        };

        List<Pineapple> pineapples = new ArrayList<>();

        Pineapple minPineapple = new Pineapple(3, 3);
        Pineapple maxPineapple = new Pineapple(2, 6);

        pineapples.add(new Pineapple(1, 4));
        pineapples.add(new Pineapple(2, 4));
        pineapples.add(new Pineapple(3, 3));
        pineapples.add(new Pineapple(4,2));
        pineapples.add(new Pineapple(5, 2));
        pineapples.add(new Pineapple(5, 3));
        pineapples.add(new Pineapple(5, 4));

        List<Pineapple> bestPineApples = CollectionUtils.range(pineapples, minPineapple, maxPineapple, comparator);
        List<Fruit> bestFruits = CollectionUtils.range(pineapples, minPineapple, maxPineapple, comparator);
        List<Eatable> bestEatable = CollectionUtils.range(pineapples, minPineapple, maxPineapple, comparator);

        assertEquals(5, bestPineApples.size());
        assertEquals(5, bestFruits.size());
        assertEquals(5, bestEatable.size());
    }
}
