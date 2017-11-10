package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.quack_behaviors;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.QuackBehavior;

/**
 * Rubber duck cant quack, but can squeak
 * */
public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Duck squeaks");
    }
}
