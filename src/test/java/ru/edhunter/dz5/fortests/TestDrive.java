package ru.edhunter.dz5.fortests;

public class TestDrive {
    public static void main(String[] args) {
        TestClass<Fruit> fruitHolder = new TestClass<>(new Fruit(6));
        Apple apple = new Apple(3);
        fruitHolder.setT(apple);
    }
}
