package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.FlyBehavior;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.interfaces.QuackBehavior;

/**
 * Abstract class, which childes may use different behavior
 */
public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public void swim() {
        System.out.println("Swimming...");
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
