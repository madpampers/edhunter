package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.fly_behaviors;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.FlyBehavior;

/**
 * If duck can fly, it uses that behavior
 * */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Duck uses wings and fly!");
    }
}
