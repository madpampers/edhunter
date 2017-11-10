package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.fly_behaviors;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.FlyBehavior;

/**
 * If duck cant fly, it uses that behavior
 * */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("This duck cannot fly...");
    }
}
