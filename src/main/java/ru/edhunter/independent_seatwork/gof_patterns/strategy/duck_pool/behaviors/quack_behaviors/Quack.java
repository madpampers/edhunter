package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.quack_behaviors;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.QuackBehavior;

/**
 * Normally ducks can quack
 * */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Duck quacks");
    }
}
