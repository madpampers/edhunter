package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks;

/**
 * Rubber duck, cant fly, and squeaks instead if quack
 * */
public class RubberDuck extends Duck{
    @Override
    public void display() {
        System.out.println("Rubber duck shows!");
    }
}
