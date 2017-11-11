package ru.edhunter.dz5;

import org.junit.Test;
import ru.edhunter.dz5.fortests.Apple;
import ru.edhunter.dz5.fortests.Eatable;
import ru.edhunter.dz5.fortests.Fruit;
import ru.edhunter.dz5.fortests.Pineapple;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestCountMap {
    @Test
    public void testBasicFunctionality() {
        CountMap<Integer> integerCountMap = new HashCountMapImpl<>();

        integerCountMap.add(10);
        integerCountMap.add(10);
        integerCountMap.add(5);
        integerCountMap.add(6);
        integerCountMap.add(5);
        integerCountMap.add(10);

        assertEquals(2, integerCountMap.getCount(5));
        assertEquals(1, integerCountMap.getCount(6));
        assertEquals(3, integerCountMap.getCount(10));

        assertEquals(3, integerCountMap.size());

        CountMap<String> stringCountMap = new HashCountMapImpl<>();

        stringCountMap.add("three");
        stringCountMap.add("three");
        stringCountMap.add("two");
        stringCountMap.add("one");
        stringCountMap.add("two");
        stringCountMap.add("three");

        assertEquals(3, stringCountMap.getCount("three"));
        assertEquals(1, stringCountMap.getCount("one"));
        assertEquals(2, stringCountMap.getCount("two"));

        assertEquals(3, stringCountMap.size());
    }

    @Test
    public void testDifferentSubclassesInMap() {
        CountMap<Fruit> fruitCountMap = new HashCountMapImpl<>();
        fruitCountMap.add(new Fruit(2));
        fruitCountMap.add(new Fruit(2));
        fruitCountMap.add(new Fruit(3));
        fruitCountMap.add(new Fruit(3));
        fruitCountMap.add(new Fruit(3));
        fruitCountMap.add(new Fruit(1));
        fruitCountMap.add(new Pineapple(2));
        fruitCountMap.add(new Pineapple(2));

        assertEquals(3, fruitCountMap.getCount(new Fruit(3)));
        assertEquals(2, fruitCountMap.getCount(new Fruit(2)));
        assertEquals(1, fruitCountMap.getCount(new Fruit(1)));
        assertEquals(0, fruitCountMap.getCount(new Fruit(5)));
        assertEquals(0, fruitCountMap.getCount(new Apple(3)));
        assertEquals(2, fruitCountMap.getCount(new Pineapple(2)));
    }

    @Test
    public void testRemoveFromCountMap() {
        CountMap<String> stringCountMap = new HashCountMapImpl<>();

        stringCountMap.add("three");
        stringCountMap.add("three");
        stringCountMap.add("two");
        stringCountMap.add("one");
        stringCountMap.add("two");
        stringCountMap.add("three");

        assertEquals(3, stringCountMap.size());

        assertEquals(3, stringCountMap.remove("three"));
        assertEquals(2, stringCountMap.size());

        assertEquals(2, stringCountMap.remove("two"));
        assertEquals(1, stringCountMap.size());

        assertEquals(1, stringCountMap.remove("one"));
        assertEquals(0, stringCountMap.size());

        assertEquals(0, stringCountMap.remove("test"));
    }

    @Test
    public void testAddAllCountMap() {
        CountMap<Integer> destinationIntegerCountMap = new HashCountMapImpl<>();

        destinationIntegerCountMap.add(10);
        destinationIntegerCountMap.add(10);
        destinationIntegerCountMap.add(5);
        destinationIntegerCountMap.add(6);
        destinationIntegerCountMap.add(5);
        destinationIntegerCountMap.add(10);

        CountMap<Integer> sourceIntegerCountMap = new HashCountMapImpl<>();
        sourceIntegerCountMap.add(10);
        sourceIntegerCountMap.add(10);
        sourceIntegerCountMap.add(6);

        destinationIntegerCountMap.addAll(sourceIntegerCountMap);

        assertEquals(5, destinationIntegerCountMap.getCount(10));
        assertEquals(2, destinationIntegerCountMap.getCount(6));
        assertEquals(2, destinationIntegerCountMap.getCount(5));
    }

    @Test
    public void testAddAllCountMapSubclasses() {
        CountMap<Fruit> destinationFruitCountMap = new HashCountMapImpl<>();

        destinationFruitCountMap.add(new Apple(2));
        destinationFruitCountMap.add(new Apple(3));
        destinationFruitCountMap.add(new Fruit(4));
        destinationFruitCountMap.add(new Pineapple(4));

        CountMap<Fruit> sourceFruitCountMap = new HashCountMapImpl<>();

        sourceFruitCountMap.add(new Apple(2));
        sourceFruitCountMap.add(new Fruit(2));
        sourceFruitCountMap.add(new Pineapple(4));

        destinationFruitCountMap.addAll(sourceFruitCountMap);

        assertEquals(2, destinationFruitCountMap.getCount(new Apple(2)));
        assertEquals(1, destinationFruitCountMap.getCount(new Apple(3)));
        assertEquals(1, destinationFruitCountMap.getCount(new Fruit(4)));
        assertEquals(2, destinationFruitCountMap.getCount(new Pineapple(4)));
        assertEquals(1, destinationFruitCountMap.getCount(new Fruit(2)));
    }

    @Test
    public void testAddAllCountMapOfSubclassesToParentMap() {
        CountMap<Eatable> destinationEatableCountMap = new HashCountMapImpl<>();

        destinationEatableCountMap.add(new Apple(2));
        destinationEatableCountMap.add(new Apple(3));
        destinationEatableCountMap.add(new Fruit(4));
        destinationEatableCountMap.add(new Pineapple(4));

        CountMap<Fruit> sourceFruitCountMap = new HashCountMapImpl<>();

        sourceFruitCountMap.add(new Apple(2));
        sourceFruitCountMap.add(new Fruit(2));
        sourceFruitCountMap.add(new Pineapple(4));

        destinationEatableCountMap.addAll(sourceFruitCountMap);

        assertEquals(2, destinationEatableCountMap.getCount(new Apple(2)));
        assertEquals(1, destinationEatableCountMap.getCount(new Apple(3)));
        assertEquals(1, destinationEatableCountMap.getCount(new Fruit(4)));
        assertEquals(2, destinationEatableCountMap.getCount(new Pineapple(4)));
        assertEquals(1, destinationEatableCountMap.getCount(new Fruit(2)));
    }

    @Test
    public void testToMap() {
        CountMap<Fruit> sourceFruitCountMap = new HashCountMapImpl<>();

        sourceFruitCountMap.add(new Apple(2));
        sourceFruitCountMap.add(new Fruit(2));
        sourceFruitCountMap.add(new Pineapple(4));

        Map<Fruit, Integer> fruitMap = sourceFruitCountMap.toMap();

        assertEquals(3, fruitMap.size());
        for (Fruit fruit : fruitMap.keySet()) {
            int value = fruitMap.get(fruit);
            int count = sourceFruitCountMap.getCount(fruit);
            assertEquals(count, value);
        }
    }

    @Test
    public void testToMapWithMapInArgument() {
        Map<Fruit, Integer> fruitMap = new HashMap<>();

        CountMap<Fruit> sourceFruitCountMap = new HashCountMapImpl<>();

        sourceFruitCountMap.add(new Apple(2));
        sourceFruitCountMap.add(new Fruit(2));
        sourceFruitCountMap.add(new Pineapple(4));

        sourceFruitCountMap.toMap(fruitMap);

        assertEquals(3, fruitMap.size());
    }

    @Test
    public void testToMapWithParentMapInArgument() {
        Map<Eatable, Number> eatableMap = new HashMap<>();

        CountMap<Fruit> sourceFruitCountMap = new HashCountMapImpl<>();

        sourceFruitCountMap.add(new Apple(4));
        sourceFruitCountMap.add(new Fruit(2));
        sourceFruitCountMap.add(new Pineapple(4));

        sourceFruitCountMap.toMap(eatableMap);

        assertEquals(3, eatableMap.size());
    }
}
