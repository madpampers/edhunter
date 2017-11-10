package ru.edhunter.independent_seatwork.gof_patterns.adapter.duck_turkey;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack, quack!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }

    @Override
    public void swim() {
        System.out.println("I can swim!");
    }
}
