package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.quack_behaviors;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.QuackBehavior;

/**
 * Algorithm that may use for example wood duck, because it cant quack or squeak
 * */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("This duck is silent, no quack");
    }
}
